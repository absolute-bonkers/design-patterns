# Observer

**Intent:** Define a one-to-many dependency so a subject can notify interested
observers when its state changes.

`StockTicker` is the subject. Consumers subscribe to receive immutable
`PriceUpdate` values when the price changes, and can unsubscribe to stop
receiving future updates.

```java
var ticker = new StockTicker("ACME", new BigDecimal("10.00"));
ticker.subscribe(update -> System.out.println(update.price()));
ticker.setPrice(new BigDecimal("12.50"));
```

- Implementation: [StockTicker.java](src/main/java/org/example/behavioral/observer/StockTicker.java)
- Tests: [StockTickerTest.java](src/test/java/org/example/behavioral/observer/StockTickerTest.java)

Observers are useful for event-driven UI updates, domain events, and
publish/subscribe relationships. Synchronous notification couples a publisher
to subscriber latency and exceptions; asynchronous delivery needs explicit
ordering, back-pressure, and lifecycle policies.

### Spring Boot connection

For application-wide events, Spring's `ApplicationEventPublisher` and
`@EventListener` provide a framework-managed observer relationship:

```java
import org.example.behavioral.observer.StockTicker.PriceUpdate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class PricePublisher {
    private final ApplicationEventPublisher events;

    PricePublisher(ApplicationEventPublisher events) {
        this.events = events;
    }

    void changed(PriceUpdate update) {
        events.publishEvent(update);
    }
}

@Component
class PriceAlert {
    @EventListener
    void onPriceUpdate(PriceUpdate update) {
        System.out.println(update);
    }
}
```

The module's plain-Java ticker remains the smaller version to start with; Spring handles
listener discovery and application event delivery for a real Boot app.
