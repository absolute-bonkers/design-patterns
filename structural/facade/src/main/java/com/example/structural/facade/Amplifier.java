package com.example.structural.facade;

public final class Amplifier {
    private String mode = "off";

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String mode() {
        return mode;
    }
}
