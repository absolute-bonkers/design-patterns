package com.example.structural.bridge;

import java.util.Objects;

public class RemoteControl {
    private final Device device;

    public RemoteControl(Device device) {
        this.device = Objects.requireNonNull(device, "device");
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void channelUp() {
        device.setChannel(device.channel() + 1);
    }

    public void channelDown() {
        if (device.channel() > 1) {
            device.setChannel(device.channel() - 1);
        }
    }
}
