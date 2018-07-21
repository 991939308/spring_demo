import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import producers.producerService;

public class Appproducer {
    public static void main(String[] args){
//        导入Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
//        获取生产者实现类
        producerService service = context.getBean(producers.producerService.class);
        for(int i = 0 ; i < 100;i++){
            service.sendMessage("text"+i);//生产者的服务的实现类中的
        }

//        关闭链接
        context.close();

    }

}
