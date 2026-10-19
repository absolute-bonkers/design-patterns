# Bridge

Bridge separates an abstraction from its implementation so both can vary independently. Instead of creating a subclass for every combination, the abstraction holds a reference to an implementation.

## Structure and example

[`RemoteControl`](src/main/java/com/example/structural/bridge/RemoteControl.java) is the abstraction and delegates device-specific operations to [`Device`](src/main/java/com/example/structural/bridge/Device.java). [`Radio`](src/main/java/com/example/structural/bridge/Radio.java) and [`Television`](src/main/java/com/example/structural/bridge/Television.java) are implementations.

```java
Device device = new Television();
RemoteControl remote = new RemoteControl(device);
remote.togglePower();
remote.channelUp();
```

## Tradeoffs and uses

Use Bridge when two dimensions of variation (such as device type and control type, renderer and shape, or storage and repository) need to evolve separately. It reduces combinatorial inheritance but introduces extra interfaces and indirection; for a single fixed implementation, that flexibility may not justify the structure.

See [remote-control tests](src/test/java/com/example/structural/bridge/RemoteControlTest.java) for implementation substitution, state changes, and channel boundaries.
