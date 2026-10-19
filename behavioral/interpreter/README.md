# Interpreter

**Intent:** Represent a small language as an object structure and evaluate
sentences in that language.

`Expression` is the grammar's common interface. `Number`, `Variable`, `Add`,
and `Multiply` are terminal/nonterminal expression nodes; interpreting the
tree recursively evaluates it against a variable map. Build
`2 + x * 3` as nested expression objects to make precedence explicit:

```java
var expression = new Expressions.Add(
    new Expressions.Number(2),
    new Expressions.Multiply(
        new Expressions.Variable("x"), new Expressions.Number(3)));
int result = expression.interpret(Map.of("x", 4)); // 14
```

- Implementation: [Expressions.java](src/main/java/org/example/behavioral/interpreter/Expressions.java)
- Tests: [ExpressionsTest.java](src/test/java/org/example/behavioral/interpreter/ExpressionsTest.java)

This approach fits small, stable DSLs such as filters or configuration
expressions. It is easy to extend with new grammar rules, but many grammar
productions can produce many classes and recursive evaluation may be
inefficient. Larger languages generally benefit from a parser and AST tooling.
