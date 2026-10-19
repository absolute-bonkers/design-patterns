# Composite

Composite lets clients treat a single object and a tree of objects through one component interface. Operations on a composite are delegated recursively to its children.

## Structure and example

[`FileSystemNode`](src/main/java/com/example/structural/composite/FileSystemNode.java) is the shared component. [`FileNode`](src/main/java/com/example/structural/composite/FileNode.java) is a leaf, and [`DirectoryNode`](src/main/java/com/example/structural/composite/DirectoryNode.java) is a composite whose size is the sum of its descendants.

```java
DirectoryNode folder = new DirectoryNode("reports");
folder.add(new FileNode("summary.txt", 240));
long bytes = folder.sizeInBytes(); // 240
```

## Tradeoffs and uses

This pattern is useful for file trees, UI hierarchies, organization charts, and nested expressions where the same operation applies at every level. Recursive traversal is convenient, but large or cyclic graphs can make operations expensive or non-terminating. This example rejects direct self-containment, exposes a read-only child snapshot, and uses non-negative file sizes.

See [composite tests](src/test/java/com/example/structural/composite/DirectoryNodeTest.java) for nested aggregation, empty/removal behavior, and validation.
