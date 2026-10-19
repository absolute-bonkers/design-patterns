package org.example.behavioral.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CheckoutTest {
    @Test
    void strategyCanBeChangedAtRuntime() {
        var checkout = new Checkout(Checkout.STANDARD);
        var subtotal = new BigDecimal("19.99");
        assertEquals(subtotal, checkout.total(subtotal));

        checkout.setStrategy(Checkout.percentageOff(new BigDecimal("25")));
        assertEquals(new BigDecimal("14.99"), checkout.total(subtotal));
    }

    @Test
    void validatesDiscountAndSubtotal() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Checkout.percentageOff(new BigDecimal("101")));
        assertThrows(
                IllegalArgumentException.class,
                () -> new Checkout(Checkout.STANDARD).total(new BigDecimal("-1")));
    }
}
