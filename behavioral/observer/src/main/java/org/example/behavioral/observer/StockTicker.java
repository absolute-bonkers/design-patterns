package org.example.behavioral.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/** A subject broadcasts immutable price updates to its current subscribers. */
public final class StockTicker {
    public record PriceUpdate(String symbol, BigDecimal price) {}

    private final String symbol;
    private final List<Consumer<PriceUpdate>> observers = new ArrayList<>();
    private BigDecimal price;

    public StockTicker(String symbol, BigDecimal initialPrice) {
        this.symbol = Objects.requireNonNull(symbol, "symbol");
        this.price = Objects.requireNonNull(initialPrice, "initialPrice");
    }

    public void subscribe(Consumer<PriceUpdate> observer) {
        observers.add(Objects.requireNonNull(observer, "observer"));
    }

    public boolean unsubscribe(Consumer<PriceUpdate> observer) {
        return observers.remove(observer);
    }

    public void setPrice(BigDecimal newPrice) {
        price = Objects.requireNonNull(newPrice, "newPrice");
        PriceUpdate update = new PriceUpdate(symbol, price);
        for (Consumer<PriceUpdate> observer : List.copyOf(observers)) {
            observer.accept(update);
        }
    }

    public BigDecimal price() {
        return price;
    }
}
