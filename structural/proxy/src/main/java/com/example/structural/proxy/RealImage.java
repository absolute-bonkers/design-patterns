package com.example.structural.proxy;

import java.util.Objects;

public final class RealImage implements Image {
    private final String path;

    public RealImage(String path) {
        this.path = Objects.requireNonNull(path, "path");
    }

    @Override
    public String display() {
        return "Displaying image: " + path;
    }
}
