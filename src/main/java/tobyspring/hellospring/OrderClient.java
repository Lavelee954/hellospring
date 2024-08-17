package tobyspring.hellospring;

import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderService;

public class OrderClient {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
    OrderService service = beanFactory.getBean(OrderService.class);

    Order order = service.createOrder("O100", BigDecimal.TEN);
    System.out.println(order);
  }
}
