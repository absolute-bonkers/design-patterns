package com.example.structural.decorator;

public final class VanillaSyrup extends CoffeeDecorator {
    public VanillaSyrup(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee().description() + ", vanilla syrup";
    }

    @Override
    public double cost() {
        return coffee().cost() + 0.40;
    }
}
