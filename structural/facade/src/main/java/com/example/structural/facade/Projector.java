package com.example.structural.facade;

public final class Projector {
    private boolean on;

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
