# Adapter

Adapter converts one interface into another that a client expects. It lets otherwise incompatible collaborators work together without changing either collaborator.

## Structure and example

The client consumes [`TemperatureSensor`](src/main/java/com/example/structural/adapter/TemperatureSensor.java), which reports Celsius. A legacy device exposes [`LegacyFahrenheitSensor`](src/main/java/com/example/structural/adapter/LegacyFahrenheitSensor.java); [`FahrenheitSensorAdapter`](src/main/java/com/example/structural/adapter/FahrenheitSensorAdapter.java) wraps that device and translates each reading.

```java
LegacyFahrenheitSensor legacy = () -> 68.0;
TemperatureSensor sensor = new FahrenheitSensorAdapter(legacy);
double celsius = sensor.temperatureCelsius(); // 20.0
```

The adapter retains the wrapped device rather than inheriting from it (object adapter). Its conversion is performed on every call, so a live sensor is not accidentally cached.

## Tradeoffs and uses

Adapters are useful for integrating third-party APIs, replacing legacy components incrementally, or keeping a domain-facing interface stable. They add a small layer and can conceal important differences in semantics; if interfaces can be changed together, direct alignment is usually simpler.

See [adapter tests](src/test/java/com/example/structural/adapter/FahrenheitSensorAdapterTest.java) for conversion, fresh readings, and invalid construction.
