package com.example.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CoffeeDecoratorTest {
    @Test
    void stacksOptionalFeaturesWithoutChangingTheBaseCoffee() {
        Coffee plain = new Espresso();
        Coffee customized = new VanillaSyrup(new Milk(plain));

        assertEquals("Espresso", plain.description());
        assertEquals(2.00, plain.cost(), 0.0001);
        assertEquals("Espresso, milk, vanilla syrup", customized.description());
        assertEquals(2.90, customized.cost(), 0.0001);
    }

    @Test
    void decoratorsCanBeAppliedInDifferentOrders() {
        Coffee coffee = new Milk(new VanillaSyrup(new Espresso()));

        assertEquals("Espresso, vanilla syrup, milk", coffee.description());
        assertEquals(2.90, coffee.cost(), 0.0001);
    }

    @Test
    void rejectsMissingWrappedCoffee() {
        assertThrows(NullPointerException.class, () -> new Milk(null));
    }
}
