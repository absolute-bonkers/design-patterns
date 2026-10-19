# Iterator

**Intent:** Provide a standard way to visit elements sequentially without
exposing a collection's internal representation.

`Playlist` owns its list and implements `Iterable<String>`. Each call to
`iterator()` traverses a stable snapshot, so later additions do not change an
iterator already in progress. It also follows the Java iterator contract:
`next()` after exhaustion throws `NoSuchElementException`.

```java
var playlist = new Playlist();
playlist.add("Blue in Green");
for (String song : playlist) {
    System.out.println(song);
}
```

- Implementation: [Playlist.java](src/main/java/org/example/behavioral/iterator/Playlist.java)
- Tests: [PlaylistTest.java](src/test/java/org/example/behavioral/iterator/PlaylistTest.java)

Iterators work well for uniform traversal, lazy sequences, and hiding storage
choices. Snapshot traversal costs memory proportional to collection size and
does not reflect subsequent changes; live iterators require a deliberate
concurrent-modification policy.
