package consumers;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {//表示已经监听到信息，处理信息
        TextMessage textMessage = (TextMessage) message;//把监听到的消息强制转换成TextMessage

        try {
            System.out.println("接受消息"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
