package tobyspring.hellospring;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.order.Order;

import java.math.BigDecimal;
import tobyspring.hellospring.order.OrderRepository;

public class DataClient {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
    OrderRepository repository = beanFactory.getBean(OrderRepository.class);
    JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);

    try {
      new TransactionTemplate(transactionManager).execute(status -> {
        Order order = new Order("100", BigDecimal.TEN);
        repository.save(order);

        System.out.println(order);

        Order order2 = new Order("100", BigDecimal.ONE);

        return null;
      });
    } catch (DataIntegrityViolationException e) {
      System.out.println("주문번호 중복 복구 작업");

    }
  }
}
