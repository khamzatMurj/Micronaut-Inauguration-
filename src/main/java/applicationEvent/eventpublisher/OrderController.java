package applicationEvent.eventpublisher;

import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller("/Order")
public class OrderController {

    private final ApplicationEventPublisher<OrderEvent> orderEventpublisher;

    public OrderController(ApplicationEventPublisher<OrderEvent> orderEventpublisher) {
        this.orderEventpublisher = orderEventpublisher;
    }

    @Post
    @Status(HttpStatus.CREATED)
    void save(){
        Order order = new Order(new BigDecimal(100.00), LocalDateTime.now());
        OrderEvent event = new OrderEvent(order);
        orderEventpublisher.publishEvent(event); // is synchrone

    }

}
