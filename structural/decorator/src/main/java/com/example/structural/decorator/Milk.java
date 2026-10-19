package com.example.structural.decorator;

public final class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee().description() + ", milk";
    }

    @Override
    public double cost() {
        return coffee().cost() + 0.50;
    }
}
