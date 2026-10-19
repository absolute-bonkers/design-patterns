package com.example.structural.proxy;

import java.util.Objects;

public final class ImageProxy implements Image {
    private final String path;
    private RealImage realImage;

    public ImageProxy(String path) {
        Objects.requireNonNull(path, "path");
        if (path.isBlank()) {
            throw new IllegalArgumentException("path cannot be blank");
        }
        this.path = path;
    }

    @Override
    public String display() {
        if (realImage == null) {
            realImage = new RealImage(path);
        }
        return realImage.display();
    }

    public boolean isLoaded() {
        return realImage != null;
    }
}
