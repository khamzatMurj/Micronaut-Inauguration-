package applicationEvent.eventpublisher;

import io.micronaut.context.event.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * // @param source The object on which the Event initially occurred.
     * //@throws IllegalArgumentException if source is null.
     */
    // emitting an event with the appropriate object
    public OrderEvent(Order order) {
        super(order);
    }
}
