package com.example.structural.flyweight;

import java.util.Objects;

public final class Tree {
    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = Objects.requireNonNull(type, "type");
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public TreeType type() {
        return type;
    }

    public String draw() {
        return type.species() + " tree (" + type.color() + ", " + type.texture() + ") at " + x + "," + y;
    }
}
