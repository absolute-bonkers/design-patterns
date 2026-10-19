package com.example.structural.flyweight;

import java.util.Objects;

public record TreeType(String species, String color, String texture) {
    public TreeType {
        Objects.requireNonNull(species, "species");
        Objects.requireNonNull(color, "color");
        Objects.requireNonNull(texture, "texture");
        if (species.isBlank() || color.isBlank() || texture.isBlank()) {
            throw new IllegalArgumentException("tree type attributes cannot be blank");
        }
    }
}
