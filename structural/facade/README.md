# Facade

Facade provides a unified, higher-level entry point to a subsystem. It coordinates existing subsystem objects but does not replace or prevent clients from using them directly.

## Structure and example

[`HomeTheaterFacade`](src/main/java/com/example/structural/facade/HomeTheaterFacade.java) coordinates [`Amplifier`](src/main/java/com/example/structural/facade/Amplifier.java), [`Projector`](src/main/java/com/example/structural/facade/Projector.java), and [`MediaPlayer`](src/main/java/com/example/structural/facade/MediaPlayer.java).

```java
HomeTheaterFacade theater =
    new HomeTheaterFacade(new Amplifier(), new Projector(), new MediaPlayer());
theater.watchMovie("Metropolis");
// Later:
theater.endMovie();
```

## Tradeoffs and uses

Use Facade to simplify a complex library, service subsystem, or startup/shutdown workflow while keeping subsystem APIs available for advanced clients. A facade centralizes orchestration and reduces coupling, but should not become a catch-all “god object”; keep it focused and preserve clear subsystem boundaries.

See [facade tests](src/test/java/com/example/structural/facade/HomeTheaterFacadeTest.java) for coordinated state transitions and input validation.
