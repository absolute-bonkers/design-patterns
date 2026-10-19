# Template Method

**Intent:** Define an algorithm skeleton in a base class and let subclasses
implement selected steps without changing the overall sequence.

`Beverage.prepare()` is final and fixes the order of boiling water, brewing,
pouring, and adding a condiment. Coffee and tea supply the variable steps.

```java
List<String> steps = new Beverage.Coffee().prepare();
// boil water, brew coffee grounds, pour into cup, add sugar and milk
```

- Implementation: [Beverage.java](src/main/java/org/example/behavioral/template/Beverage.java)
- Tests: [BeverageTest.java](src/test/java/org/example/behavioral/template/BeverageTest.java)

Template Method is useful for workflows with invariant orchestration and
customizable steps, such as import pipelines or test fixtures. Inheritance
creates a compile-time coupling to the base class; composition or a strategy
can be easier to vary independently.

For a Spring Boot example in everyday use, `JdbcTemplate` owns the connection,
statement, and cleanup workflow while a callback supplies the query-specific
work. The beverage example keeps the pattern's subclass-based template shape
small and explicit.
