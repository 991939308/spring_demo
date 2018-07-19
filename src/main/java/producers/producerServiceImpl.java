package producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.print.attribute.standard.Destination;

public class producerServiceImpl implements producerService{

    @Autowired
    JmsTemplate jmsTemplate;

    @Resource(name="queueDestination")
    Destination destination;
    public void sendMessage(String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("发送消息"+textMessage.getText());
                return textMessage;
            }
        });//目的地、创建者、
    }
}
