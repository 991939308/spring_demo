package consumers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Appconsumer {
    public static void main(String[] arge){
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

    }
}
