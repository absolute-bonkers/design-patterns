package org.example.behavioral.interpreter;

import java.util.Map;
import java.util.Objects;

/** Expressions form and evaluate a tiny integer arithmetic language. */
public final class Expressions {
    private Expressions() {}

    public interface Expression {
        int interpret(Map<String, Integer> variables);
    }

    public record Number(int value) implements Expression {
        @Override
        public int interpret(Map<String, Integer> variables) {
            return value;
        }
    }

    public record Variable(String name) implements Expression {
        public Variable {
            Objects.requireNonNull(name, "name");
        }

        @Override
        public int interpret(Map<String, Integer> variables) {
            Objects.requireNonNull(variables, "variables");
            Integer value = variables.get(name);
            if (value == null) {
                throw new IllegalArgumentException("No value supplied for variable: " + name);
            }
            return value;
        }
    }

    public record Add(Expression left, Expression right) implements Expression {
        public Add {
            Objects.requireNonNull(left, "left");
            Objects.requireNonNull(right, "right");
        }

        @Override
        public int interpret(Map<String, Integer> variables) {
            return left.interpret(variables) + right.interpret(variables);
        }
    }

    public record Multiply(Expression left, Expression right) implements Expression {
        public Multiply {
            Objects.requireNonNull(left, "left");
            Objects.requireNonNull(right, "right");
        }

        @Override
        public int interpret(Map<String, Integer> variables) {
            return left.interpret(variables) * right.interpret(variables);
        }
    }
}
