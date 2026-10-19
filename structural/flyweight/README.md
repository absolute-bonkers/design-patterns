# Flyweight

Flyweight reduces memory use when many objects share substantial common state. It stores shared, immutable intrinsic state once and passes varying extrinsic state from the client.

## Structure and example

[`TreeType`](src/main/java/com/example/structural/flyweight/TreeType.java) is the immutable intrinsic state (species, color, texture). [`TreeTypeFactory`](src/main/java/com/example/structural/flyweight/TreeTypeFactory.java) interns equivalent types; each [`Tree`](src/main/java/com/example/structural/flyweight/Tree.java) keeps its own coordinates.

```java
TreeTypeFactory types = new TreeTypeFactory();
TreeType oak = types.getTreeType("oak", "green", "rough");
Tree one = new Tree(2, 5, oak);
Tree two = new Tree(8, 13, types.getTreeType("oak", "green", "rough"));
// one and two share oak, but retain different coordinates.
```

## Tradeoffs and uses

Flyweight can reduce allocation for large populations such as glyphs, map markers, particles, or game-world objects. It shifts complexity to distinguishing shared from per-instance data and requires shared state to be safe to reuse (typically immutable). The concurrent factory safely reuses immutable value keys across callers.

See [flyweight tests](src/test/java/com/example/structural/flyweight/TreeTypeFactoryTest.java) for cache identity, extrinsic coordinates, and distinct state.
