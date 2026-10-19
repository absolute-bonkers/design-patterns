package com.example.structural.bridge;

public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int channel();

    void setChannel(int channel);
}
