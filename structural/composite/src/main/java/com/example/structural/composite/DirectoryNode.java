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
        if (child == this || (child instanceof DirectoryNode directory && directory.contains(this))) {
            throw new IllegalArgumentException("adding this child would create a directory cycle");
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

    private boolean contains(FileSystemNode candidate) {
        if (children.contains(candidate)) {
            return true;
        }
        return children.stream()
                .filter(DirectoryNode.class::isInstance)
                .map(DirectoryNode.class::cast)
                .anyMatch(directory -> directory.contains(candidate));
    }
}
