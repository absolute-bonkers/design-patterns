package com.example.structural.adapter;

import java.util.Objects;

public final class FahrenheitSensorAdapter implements TemperatureSensor {
    private final LegacyFahrenheitSensor legacySensor;

    public FahrenheitSensorAdapter(LegacyFahrenheitSensor legacySensor) {
        this.legacySensor = Objects.requireNonNull(legacySensor, "legacySensor");
    }

    @Override
    public double temperatureCelsius() {
        return (legacySensor.readTemperatureFahrenheit() - 32.0) * 5.0 / 9.0;
    }
}
