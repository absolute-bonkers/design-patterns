package com.example.structural.bridge;

public final class Television implements Device {
    private boolean enabled;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int channel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        if (channel < 1) {
            throw new IllegalArgumentException("channel must be positive");
        }
        this.channel = channel;
    }
}
