package com.example.structural.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RemoteControlTest {
    @Test
    void sameRemoteControlsDifferentDeviceImplementations() {
        Device radio = new Radio();
        Device television = new Television();
        RemoteControl radioRemote = new RemoteControl(radio);
        RemoteControl televisionRemote = new RemoteControl(television);

        radioRemote.togglePower();
        televisionRemote.channelUp();

        assertTrue(radio.isEnabled());
        assertFalse(television.isEnabled());
        assertEquals(1, radio.channel());
        assertEquals(2, television.channel());
    }

    @Test
    void channelDownDoesNotMoveBelowFirstChannel() {
        Device device = new Radio();
        RemoteControl remote = new RemoteControl(device);

        remote.channelDown();

        assertEquals(1, device.channel());
    }

    @Test
    void devicesRejectInvalidChannels() {
        assertThrows(IllegalArgumentException.class, () -> new Television().setChannel(0));
        assertThrows(NullPointerException.class, () -> new RemoteControl(null));
    }
}
