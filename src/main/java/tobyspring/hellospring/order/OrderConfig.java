package tobyspring.hellospring.order;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import tobyspring.hellospring.DataConfig;
import tobyspring.hellospring.data.OrderRepository;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {

  @Bean
  public OrderRepository OrderRepository() {
    return new OrderRepository();
  }

  @Bean
  public OrderService orderService(JpaTransactionManager transactionManager) {
    return new OrderService(OrderRepository(), transactionManager);
  }
}
