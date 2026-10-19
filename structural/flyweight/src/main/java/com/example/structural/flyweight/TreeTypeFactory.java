package com.example.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class TreeTypeFactory {
    private final Map<TreeType, TreeType> types = new ConcurrentHashMap<>();

    public TreeType getTreeType(String species, String color, String texture) {
        TreeType key = new TreeType(species, color, texture);
        return types.computeIfAbsent(key, ignored -> key);
    }

    public int cachedTypeCount() {
        return types.size();
    }
}
