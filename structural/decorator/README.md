# Decorator

Decorator adds behavior or responsibilities to an object dynamically by wrapping it with another object that implements the same interface. Multiple decorators can be composed without creating a subclass for every combination.

## Structure and example

[`Coffee`](src/main/java/com/example/structural/decorator/Coffee.java) is the component, [`Espresso`](src/main/java/com/example/structural/decorator/Espresso.java) is a concrete component, and [`Milk`](src/main/java/com/example/structural/decorator/Milk.java) and [`VanillaSyrup`](src/main/java/com/example/structural/decorator/VanillaSyrup.java) are concrete decorators built on [`CoffeeDecorator`](src/main/java/com/example/structural/decorator/CoffeeDecorator.java).

```java
Coffee order = new VanillaSyrup(new Milk(new Espresso()));
String label = order.description();
double total = order.cost(); // 2.90
```

## Tradeoffs and uses

Decorators are useful for optional features, middleware, stream transformations, and cross-cutting behavior that can be layered at runtime. Wrapping creates more objects and can make debugging or identity-sensitive code harder. Order can matter when decorators transform behavior; here the modifiers have additive cost and readable ordered descriptions.

See [coffee decorator tests](src/test/java/com/example/structural/decorator/CoffeeDecoratorTest.java) for stacking, order, and null validation.

## ☕ Spring connection

Spring Web's `HttpServletRequestWrapper` is a familiar decorator-style tool: it
wraps a request while preserving the request API, so a filter can add behavior
or adjust selected values without changing the original request implementation.
The coffee example keeps the wrapping and composition visible without framework
setup.
