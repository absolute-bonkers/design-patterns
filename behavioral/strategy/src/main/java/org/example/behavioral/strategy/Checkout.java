package org.example.behavioral.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/** Checkout delegates the price calculation to a replaceable pricing strategy. */
public final class Checkout {
    @FunctionalInterface
    public interface PricingStrategy {
        BigDecimal price(BigDecimal subtotal);
    }

    public static final PricingStrategy STANDARD = subtotal -> subtotal;

    public static PricingStrategy percentageOff(BigDecimal percent) {
        Objects.requireNonNull(percent, "percent");
        if (percent.signum() < 0 || percent.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        BigDecimal multiplier = BigDecimal.ONE.subtract(percent.movePointLeft(2));
        return subtotal -> subtotal.multiply(multiplier).setScale(2, RoundingMode.HALF_UP);
    }

    private PricingStrategy strategy;

    public Checkout(PricingStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy");
    }

    public BigDecimal total(BigDecimal subtotal) {
        Objects.requireNonNull(subtotal, "subtotal");
        if (subtotal.signum() < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        return strategy.price(subtotal);
    }
}
