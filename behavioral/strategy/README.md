# Strategy

**Intent:** Define a family of algorithms, encapsulate each one, and make
them interchangeable without changing the client using them.

`PricingStrategy` is the algorithm contract. `Checkout` delegates its total
calculation to the configured strategy; the included standard and percentage
discount strategies can be swapped at runtime.

```java
var checkout = new Checkout(Checkout.STANDARD);
checkout.setStrategy(Checkout.percentageOff(new BigDecimal("25")));
BigDecimal total = checkout.total(new BigDecimal("20.00")); // 15.00
```

- Implementation: [Checkout.java](src/main/java/org/example/behavioral/strategy/Checkout.java)
- Tests: [CheckoutTest.java](src/test/java/org/example/behavioral/strategy/CheckoutTest.java)

Strategies are useful when selecting pricing, sorting, routing, or retry
policies. They replace conditionals with composable behavior, at the cost of
more objects/configuration and a need to make strategy selection explicit.

### Spring Boot connection

When strategies are Spring beans, inject the interface rather than constructing
a concrete strategy in the client. Spring can inject a map keyed by bean name
when a request needs to select an algorithm at runtime:

```java
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("standardPricing")
class StandardPricing implements Checkout.PricingStrategy {
    @Override
    public BigDecimal price(BigDecimal subtotal) {
        return subtotal;
    }
}

@Service
class CartService {
    private final Map<String, Checkout.PricingStrategy> strategies;

    CartService(Map<String, Checkout.PricingStrategy> strategies) {
        this.strategies = Map.copyOf(strategies);
    }

    BigDecimal total(String strategyName, BigDecimal subtotal) {
        Checkout.PricingStrategy strategy = strategies.get(strategyName);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown pricing strategy: " + strategyName);
        }
        return strategy.price(subtotal);
    }
}
```

Add one bean per pricing algorithm. The dependency-free `Checkout` in this
module keeps the same strategy choice visible without requiring an application
context.
