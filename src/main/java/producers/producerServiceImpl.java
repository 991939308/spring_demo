package producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class producerServiceImpl implements producerService{

    @Autowired
    JmsTemplate jmsTemplate;

    @Resource(name="topicDestination")
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
        System.out.println("发送消息"+message);
    }
}
