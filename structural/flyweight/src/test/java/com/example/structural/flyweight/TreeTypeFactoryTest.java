package com.example.structural.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TreeTypeFactoryTest {
    @Test
    void sharesIntrinsicTypeWhileTreesKeepIndependentCoordinates() {
        TreeTypeFactory factory = new TreeTypeFactory();
        TreeType oakType = factory.getTreeType("oak", "green", "rough");
        Tree first = new Tree(2, 5, oakType);
        Tree second = new Tree(8, 13, factory.getTreeType("oak", "green", "rough"));

        assertNotSame(first, second);
        assertSame(first.type(), second.type());
        assertEquals("oak tree (green, rough) at 2,5", first.draw());
        assertEquals(8, second.x());
        assertEquals(13, second.y());
    }

    @Test
    void distinctIntrinsicStateUsesDistinctFlyweights() {
        TreeTypeFactory factory = new TreeTypeFactory();

        TreeType oak = factory.getTreeType("oak", "green", "rough");
        TreeType pine = factory.getTreeType("pine", "green", "needle");

        assertNotSame(oak, pine);
        assertEquals(2, factory.cachedTypeCount());
    }

    @Test
    void sameValuesReuseOneFlyweightAndBlankAttributesAreRejected() {
        TreeTypeFactory factory = new TreeTypeFactory();

        assertSame(
                factory.getTreeType("birch", "white", "smooth"),
                factory.getTreeType("birch", "white", "smooth"));
        assertThrows(IllegalArgumentException.class, () -> factory.getTreeType(" ", "white", "smooth"));
    }
}
