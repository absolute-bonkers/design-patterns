# State

**Intent:** Let an object change its behavior when its internal state changes,
as if it changed its class.

`Turnstile` delegates both operations to a `State`. A locked gate alarms on a
push and unlocks on a coin; an unlocked gate allows passage and then locks.
The state objects own transition behavior rather than leaving a growing
conditional in the turnstile.

```java
var gate = new Turnstile();
gate.insertCoin(); // "unlocked"
gate.push();       // "passed", then locked
```

- Implementation: [Turnstile.java](src/main/java/org/example/behavioral/state/Turnstile.java)
- Tests: [TurnstileTest.java](src/test/java/org/example/behavioral/state/TurnstileTest.java)

State is useful for protocols, order lifecycles, and UI modes with
state-dependent actions. It makes transitions explicit but can introduce many
small classes; it is most valuable when state-specific behavior is substantial.
