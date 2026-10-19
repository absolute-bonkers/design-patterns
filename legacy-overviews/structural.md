[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![GitHub watchers](https://img.shields.io/github/watchers/absolute-bonkers/design-patterns)
![GitHub Repo stars](https://img.shields.io/github/stars/absolute-bonkers/design-patterns)
![GitHub Repo forks](https://img.shields.io/github/forks/absolute-bonkers/design-patterns)

---

> **Archived category mirror:** the canonical Module 1 course now combines all
> 23 GoF patterns in the [design-patterns repository](https://github.com/absolute-bonkers/design-patterns).
> Continue there for the maintained README, guides, and tests.

## 🧱 Structural Design Patterns

**Design patterns** are like cheat codes for coding problems! They’re tried-and-true blueprints for common software
design challenges, helping keep code cleaner, easier to maintain, and more flexible. Think of them as ways to level up
your coding game. 🎮

### *Structural Design Patterns*

*Examples built with Java 21.* ☕

Structural patterns are all about **how objects and classes fit together**. Think LEGO bricks: combine the pieces in
clever ways to build something bigger without creating a tangled mess. 🧩✨

This repository is one part of the complete set of **23 Gang of Four (GoF) patterns**:

- [Creational patterns](https://github.com/absolute-bonkers/design-patterns) — object creation, minus the chaos 🛠️
- [Structural patterns](https://github.com/absolute-bonkers/design-patterns) — objects that fit together like LEGO (this repository) 🧱
- [Behavioral patterns](https://github.com/absolute-bonkers/design-patterns) — objects working together as a team 🤝

The structural examples are standalone Java 21 programs, with Spring Boot kept out where it would hide the pattern
behind framework machinery. Each chapter has an implementation, focused JUnit 5 tests, and a guide.

### Here's the structural squad:

1. **🔌 Adapter** — The universal travel plug: helps interfaces that don't quite match work together.
2. **🌉 Bridge** — Separates two dimensions of change so each can cross to the other side independently.
3. **🌳 Composite** — Treats a single object and a whole tree of objects the same way.
4. **🎁 Decorator** — Wraps an object to add features, like extra toppings without changing the original order.
5. **🏠 Facade** — One friendly front door for a complicated subsystem.
6. **🌲 Flyweight** — Shares common state to keep a crowd of similar objects lightweight.
7. **🕶️ Proxy** — A stand-in that controls access to the real object.

<br/>

*These patterns are your **superpowers** 🦸‍♂️ for composing flexible software without adding unnecessary drama! 💥*

## *⭐ Explore all 23 GoF chapters*

### 🎨 Creational — 5 patterns

1. [Singleton](../creational/dp-singleton/singleton.md) — one shared instance, VIP-style 🔑
2. [Factory Method](../creational/dp-factory/factory.md) — delegate which product gets made ☕
3. [Abstract Factory](../creational/dp-abstract-factory/abstract-factory.md) — a factory for families of related products 🏗️
4. [Builder](../creational/dp-builder/builder.md) — assemble a complex object one step at a time 🥪
5. [Prototype](../creational/dp-prototype/prototype.md) — make a new object by cloning an existing one 🧬

### 🧱 Structural — 7 patterns

1. [Adapter](../structural/adapter/README.md) — make incompatible interfaces work together 🔌
2. [Bridge](../structural/bridge/README.md) — vary abstractions and implementations independently 🌉
3. [Composite](../structural/composite/README.md) — treat leaves and object trees uniformly 🌳
4. [Decorator](../structural/decorator/README.md) — add behavior by wrapping objects 🎁
5. [Facade](../structural/facade/README.md) — simplify a subsystem with one friendly entry point 🏠
6. [Flyweight](../structural/flyweight/README.md) — share common state and save resources 🌲
7. [Proxy](../structural/proxy/README.md) — control access through a stand-in 🕶️

### 🤝 Behavioral — 11 patterns

1. [Chain of Responsibility](../behavioral/chain-of-responsibility/README.md) — pass a request along handlers until one handles it 🔗
2. [Command](../behavioral/command/README.md) — package an operation as an object 🎮
3. [Interpreter](../behavioral/interpreter/README.md) — represent and evaluate a small language 📖
4. [Iterator](../behavioral/iterator/README.md) — traverse a collection without exposing its internals 🚶
5. [Mediator](../behavioral/mediator/README.md) — coordinate colleagues through a central hub 📡
6. [Memento](../behavioral/memento/README.md) — save and restore an object's state ⏪
7. [Observer](../behavioral/observer/README.md) — notify subscribers when something changes 🔔
8. [State](../behavioral/state/README.md) — change behavior as an object's state changes 🔄
9. [Strategy](../behavioral/strategy/README.md) — swap algorithms at runtime 🧭
10. [Template Method](../behavioral/template-method/README.md) — define the algorithm's outline, customize its steps 🧪
11. [Visitor](../behavioral/visitor/README.md) — add operations to a stable object structure 🧳

## ☕ Build and test

Every module targets **Java 21** through the Gradle toolchain. Install JDK 21, then run from the repository root:

```sh
./gradlew build
./gradlew test
./gradlew :adapter:test
```

No system Gradle installation is needed—the bundled wrapper downloads the pinned Gradle 9.8.1 distribution and verifies
its SHA-256 checksum the first time you run it. Each pattern module has no runtime dependencies; JUnit 5 is used for
tests.

<br/>
<br/>

---
```Note from author: Got an idea? Want to help make this project even more epic? We'd love to hear from you! 🤩```

*Let's stay in touch:*

<p>
<a href="https://www.linkedin.com/in/adityachandeliya/">
    <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>&nbsp;&nbsp;
<a href="https://github.com/imchandeliya">
    <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" />
</a>&nbsp;&nbsp;
</p>

*Star this repo if you found it helpful! ⭐ It helps others discover it too!*

---

Made with 💻 and ☕ by [Aditya Chandeliya](https://github.com/imchandeliya)
