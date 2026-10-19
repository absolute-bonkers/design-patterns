package com.example.structural.decorator;

public final class Espresso implements Coffee {
    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}
