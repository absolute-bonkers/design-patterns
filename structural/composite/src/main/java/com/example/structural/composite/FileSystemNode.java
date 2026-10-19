package com.example.structural.composite;

public interface FileSystemNode {
    String name();

    long sizeInBytes();

    default void add(FileSystemNode child) {
        throw new UnsupportedOperationException("leaf nodes cannot contain children");
    }

    default boolean remove(FileSystemNode child) {
        throw new UnsupportedOperationException("leaf nodes cannot contain children");
    }
}
