package org.example.behavioral.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BeverageTest {
    @Test
    void templateKeepsCommonOrderAndSubclassesSupplySteps() {
        assertEquals(
                List.of("boil water", "brew coffee grounds", "pour into cup", "add sugar and milk"),
                new Beverage.Coffee().prepare());
        assertEquals(
                List.of("boil water", "steep tea", "pour into cup", "add lemon"),
                new Beverage.Tea().prepare());
    }
}
