package com.example.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DirectoryNode implements FileSystemNode {
    private final String name;
    private final List<FileSystemNode> children = new ArrayList<>();

    public DirectoryNode(String name) {
        this.name = FileNode.requireName(name);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long sizeInBytes() {
        return children.stream().mapToLong(FileSystemNode::sizeInBytes).sum();
    }

    @Override
    public void add(FileSystemNode child) {
        Objects.requireNonNull(child, "child");
        if (child == this) {
            throw new IllegalArgumentException("a directory cannot contain itself");
        }
        children.add(child);
    }

    @Override
    public boolean remove(FileSystemNode child) {
        return children.remove(child);
    }

    public List<FileSystemNode> children() {
        return List.copyOf(children);
    }
}
