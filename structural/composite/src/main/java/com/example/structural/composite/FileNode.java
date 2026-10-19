package com.example.structural.composite;

import java.util.Objects;

public final class FileNode implements FileSystemNode {
    private final String name;
    private final long sizeInBytes;

    public FileNode(String name, long sizeInBytes) {
        this.name = requireName(name);
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("sizeInBytes cannot be negative");
        }
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long sizeInBytes() {
        return sizeInBytes;
    }

    static String requireName(String name) {
        Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        return name;
    }
}
