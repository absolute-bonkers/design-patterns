package org.example.behavioral.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class StockTickerTest {
    @Test
    void notifiesSubscribersWithImmutableUpdate() {
        var ticker = new StockTicker("ACME", new BigDecimal("10.00"));
        var updates = new ArrayList<StockTicker.PriceUpdate>();
        ticker.subscribe(updates::add);

        ticker.setPrice(new BigDecimal("12.50"));

        assertEquals("ACME", updates.getFirst().symbol());
        assertEquals(new BigDecimal("12.50"), updates.getFirst().price());
    }

    @Test
    void unsubscribeStopsFutureNotifications() {
        var ticker = new StockTicker("ACME", BigDecimal.ONE);
        var updates = new ArrayList<StockTicker.PriceUpdate>();
        java.util.function.Consumer<StockTicker.PriceUpdate> observer = updates::add;
        ticker.subscribe(observer);

        assertTrue(ticker.unsubscribe(observer));
        assertFalse(ticker.unsubscribe(observer));
        ticker.setPrice(BigDecimal.TEN);
        assertTrue(updates.isEmpty());
    }
}
