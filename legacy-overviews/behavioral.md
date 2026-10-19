[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

---

> **Archived category mirror:** the canonical Module 1 course now combines all
> 23 GoF patterns in the [design-patterns repository](https://github.com/absolute-bonkers/design-patterns).
> Continue there for the maintained README, guides, and tests.

## 🧠 Behavioral Design Patterns

*Design patterns are like cheat codes for common coding problems!* ✨
They’re tried-and-true blueprints that help make software easier to understand,
extend, and maintain. This repo is the behavioral stop in our three-part GoF
series—patterns that focus on how objects communicate and share responsibility. 🤝

The full Gang of Four collection has **23 patterns** across all three repos:

- [🎨 Creational patterns](https://github.com/absolute-bonkers/design-patterns)
- [🧱 Structural patterns](https://github.com/absolute-bonkers/design-patterns)
- [🧠 Behavioral patterns](https://github.com/absolute-bonkers/design-patterns) (you are here!)

## ⭐ All 23 GoF patterns

### 🎨 Creational: creating objects without the chaos

| Pattern | The quick idea | Chapter |
| --- | --- | --- |
| Singleton | One shared instance—VIP access, no duplicates. 🔑 | [Singleton](../creational/dp-singleton/singleton.md) |
| Factory Method | Ask a creator for an object without choosing its concrete class. ☕ | [Factory Method](../creational/dp-factory/factory.md) |
| Abstract Factory | Create families of compatible objects together. 🏗️ | [Abstract Factory](../creational/dp-abstract-factory/abstract-factory.md) |
| Builder | Assemble a complex object one step at a time. 🥪 | [Builder](../creational/dp-builder/builder.md) |
| Prototype | Create a new object by cloning a ready-made one. 🧬 | [Prototype](../creational/dp-prototype/prototype.md) |

### 🧱 Structural: getting objects to fit together

| Pattern | The quick idea | Chapter |
| --- | --- | --- |
| Adapter | Make incompatible interfaces work together. 🔌 | [Adapter](../structural/adapter) |
| Bridge | Vary an abstraction and its implementation independently. 🌉 | [Bridge](../structural/bridge) |
| Composite | Treat an object and a tree of objects the same way. 🌳 | [Composite](../structural/composite) |
| Decorator | Add behavior by wrapping an object. 🎁 | [Decorator](../structural/decorator) |
| Facade | Give a complex subsystem one friendly front door. 🏠 | [Facade](../structural/facade) |
| Flyweight | Share common state to keep lots of objects lightweight. 🪶 | [Flyweight](../structural/flyweight) |
| Proxy | Control access to another object through a stand-in. 🛡️ | [Proxy](../structural/proxy) |

### 🧠 Behavioral: objects working together

| Pattern | The quick idea | Chapter |
| --- | --- | --- |
| Chain of Responsibility | Pass a request along handlers until one takes it. 🔗 | [Chain of Responsibility](../behavioral/chain-of-responsibility/README.md) |
| Command | Package an operation as an object you can run or undo. 🕹️ | [Command](../behavioral/command/README.md) |
| Interpreter | Build a tiny language from composable expressions. 🗣️ | [Interpreter](../behavioral/interpreter/README.md) |
| Iterator | Walk a collection without peeking at its internals. 🚶 | [Iterator](../behavioral/iterator/README.md) |
| Mediator | Let a coordinator simplify many-to-many conversations. 🤝 | [Mediator](../behavioral/mediator/README.md) |
| Memento | Save and restore state without exposing the internals. 📸 | [Memento](../behavioral/memento/README.md) |
| Observer | Let subscribers hear about changes they care about. 📣 | [Observer](../behavioral/observer/README.md) |
| State | Let an object's current state shape what it does next. 🔄 | [State](../behavioral/state/README.md) |
| Strategy | Swap algorithms without rewriting the client. 🧭 | [Strategy](../behavioral/strategy/README.md) |
| Template Method | Keep the workflow; customize selected steps. 🧪 | [Template Method](../behavioral/template-method/README.md) |
| Visitor | Add operations to a stable object structure. 🚶‍♀️ | [Visitor](../behavioral/visitor/README.md) |

## ☕ Java 21, Gradle, and Spring Boot

The examples across the series target **Java 21**. Creational patterns include
Spring Boot examples; the structural repo has focused, framework-free Java
implementations. This behavioral repo keeps its examples dependency-light so
the pattern mechanics are easy to see, and points out useful Spring connections
in chapters where they fit naturally (such as Spring application events for
Observer). No extra Spring-specific chapters are added.

Install JDK 21, then run these commands from this repo:

```sh
./gradlew test
./gradlew build
./gradlew :strategy:test
```

No system Gradle installation is needed—the bundled wrapper downloads the
pinned Gradle 9.8.1 distribution and verifies its SHA-256 checksum the first
time you run it. Each behavioral pattern has its own Gradle module, Java
package, focused JUnit 5 tests, and guide linking directly to the example and
tests. The behavioral examples use only the JDK at runtime.

*These patterns are your teamwork superpowers—keep the code clean, flexible,
and drama-free!* 🦸‍♀️💥
