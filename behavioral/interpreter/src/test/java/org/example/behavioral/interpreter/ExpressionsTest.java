package org.example.behavioral.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ExpressionsTest {
    @Test
    void nestedExpressionEvaluatesWithOperatorPrecedenceEncodedByTree() {
        var expression = new Expressions.Add(
                new Expressions.Number(2),
                new Expressions.Multiply(new Expressions.Variable("x"), new Expressions.Number(3)));

        assertEquals(14, expression.interpret(Map.of("x", 4)));
    }

    @Test
    void missingVariableIsReported() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Expressions.Variable("unknown").interpret(Map.of()));
    }
}
