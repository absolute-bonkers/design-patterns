package org.example.behavioral.visitor;

import java.util.Objects;

/** Stable shape types accept new operations through double dispatch. */
public final class Shapes {
    private Shapes() {}

    public interface Shape {
        <R> R accept(Visitor<R> visitor);
    }

    public interface Visitor<R> {
        R visit(Circle circle);

        R visit(Rectangle rectangle);
    }

    public record Circle(double radius) implements Shape {
        public Circle {
            if (!Double.isFinite(radius) || radius < 0) {
                throw new IllegalArgumentException("Radius must be finite and non-negative");
            }
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return Objects.requireNonNull(visitor, "visitor").visit(this);
        }
    }

    public record Rectangle(double width, double height) implements Shape {
        public Rectangle {
            if (!Double.isFinite(width) || !Double.isFinite(height) || width < 0 || height < 0) {
                throw new IllegalArgumentException("Dimensions must be finite and non-negative");
            }
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return Objects.requireNonNull(visitor, "visitor").visit(this);
        }
    }

    public static final class AreaVisitor implements Visitor<Double> {
        @Override
        public Double visit(Circle circle) {
            return Math.PI * circle.radius() * circle.radius();
        }

        @Override
        public Double visit(Rectangle rectangle) {
            return rectangle.width() * rectangle.height();
        }
    }

    public static final class DescriptionVisitor implements Visitor<String> {
        @Override
        public String visit(Circle circle) {
            return "circle with radius " + circle.radius();
        }

        @Override
        public String visit(Rectangle rectangle) {
            return "rectangle " + rectangle.width() + " x " + rectangle.height();
        }
    }
}
