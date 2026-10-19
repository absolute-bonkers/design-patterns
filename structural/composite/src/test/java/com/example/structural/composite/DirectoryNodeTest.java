package com.example.structural.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DirectoryNodeTest {
    @Test
    void aggregatesSizesRecursively() {
        DirectoryNode root = new DirectoryNode("root");
        DirectoryNode documents = new DirectoryNode("documents");
        documents.add(new FileNode("notes.txt", 120));
        documents.add(new FileNode("photo.jpg", 880));
        root.add(documents);
        root.add(new FileNode("readme.md", 40));

        assertEquals(1040, root.sizeInBytes());
        assertEquals(1000, documents.sizeInBytes());
    }

    @Test
    void emptyAndRemovedDirectoriesHaveExpectedSize() {
        DirectoryNode directory = new DirectoryNode("empty");
        FileNode file = new FileNode("data.bin", 64);
        directory.add(file);

        assertTrue(directory.remove(file));
        assertFalse(directory.remove(file));
        assertEquals(0, directory.sizeInBytes());
    }

    @Test
    void rejectsInvalidChildrenAndNames() {
        DirectoryNode directory = new DirectoryNode("folder");
        assertThrows(IllegalArgumentException.class, () -> directory.add(directory));
        assertThrows(NullPointerException.class, () -> directory.add(null));
        assertThrows(IllegalArgumentException.class, () -> new FileNode(" ", 1));
        assertThrows(IllegalArgumentException.class, () -> new FileNode("file", -1));
    }

    @Test
    void rejectsIndirectCyclesInDirectoryTree() {
        DirectoryNode root = new DirectoryNode("root");
        DirectoryNode child = new DirectoryNode("child");
        DirectoryNode grandchild = new DirectoryNode("grandchild");
        root.add(child);
        child.add(grandchild);

        assertThrows(IllegalArgumentException.class, () -> grandchild.add(root));
        assertEquals(0, grandchild.sizeInBytes());
    }
}
