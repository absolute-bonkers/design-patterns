package org.example.behavioral.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ShapesTest {
    @Test
    void visitorsApplyDifferentOperationsToSameShape() {
        Shapes.Shape circle = new Shapes.Circle(2);
        assertEquals(Math.PI * 4, circle.accept(new Shapes.AreaVisitor()));
        assertEquals("circle with radius 2.0", circle.accept(new Shapes.DescriptionVisitor()));
        assertEquals(12.0, new Shapes.Rectangle(3, 4).accept(new Shapes.AreaVisitor()));
    }

    @Test
    void dimensionsCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Shapes.Circle(-1));
        assertThrows(IllegalArgumentException.class, () -> new Shapes.Rectangle(2, -1));
    }
}
