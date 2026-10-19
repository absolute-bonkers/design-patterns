# Visitor

**Intent:** Add operations to a stable object structure without placing every
operation inside each element type. Element dispatch selects the appropriate
visitor overload (double dispatch).

Shapes accept a generic `Visitor<R>`. `AreaVisitor` and
`DescriptionVisitor` provide distinct operations over the same circle and
rectangle elements:

```java
Shapes.Shape circle = new Shapes.Circle(2);
double area = circle.accept(new Shapes.AreaVisitor());
String description = circle.accept(new Shapes.DescriptionVisitor());
```

- Implementation: [Shapes.java](src/main/java/org/example/behavioral/visitor/Shapes.java)
- Tests: [ShapesTest.java](src/test/java/org/example/behavioral/visitor/ShapesTest.java)

Visitor is useful for compilers and reports over a mostly fixed set of node
types. It makes adding operations straightforward, but adding a new element
type requires updating every visitor, so it is a poor fit when the element
hierarchy changes frequently.
