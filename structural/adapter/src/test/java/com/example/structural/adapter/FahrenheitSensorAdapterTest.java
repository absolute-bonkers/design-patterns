package com.example.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FahrenheitSensorAdapterTest {
    @Test
    void convertsLegacyReadingToCelsius() {
        TemperatureSensor sensor = new FahrenheitSensorAdapter(() -> 68.0);

        assertEquals(20.0, sensor.temperatureCelsius(), 0.0001);
    }

    @Test
    void readsTheLegacyDeviceForEachRequest() {
        double[] reading = {32.0};
        TemperatureSensor sensor = new FahrenheitSensorAdapter(() -> reading[0]);

        assertEquals(0.0, sensor.temperatureCelsius(), 0.0001);
        reading[0] = 212.0;
        assertEquals(100.0, sensor.temperatureCelsius(), 0.0001);
    }

    @Test
    void rejectsNullLegacyDevice() {
        assertThrows(NullPointerException.class, () -> new FahrenheitSensorAdapter(null));
    }
}
