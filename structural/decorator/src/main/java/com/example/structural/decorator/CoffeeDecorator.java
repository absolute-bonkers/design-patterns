package com.example.structural.decorator;

import java.util.Objects;

public abstract class CoffeeDecorator implements Coffee {
    private final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = Objects.requireNonNull(coffee, "coffee");
    }

    protected Coffee coffee() {
        return coffee;
    }
}
