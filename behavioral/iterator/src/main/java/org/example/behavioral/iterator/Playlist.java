package org.example.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/** A playlist exposes traversal but keeps its mutable storage private. */
public final class Playlist implements Iterable<String> {
    private final List<String> songs = new ArrayList<>();

    public void add(String song) {
        songs.add(Objects.requireNonNull(song, "song"));
    }

    @Override
    public Iterator<String> iterator() {
        List<String> snapshot = List.copyOf(songs);
        return new Iterator<>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < snapshot.size();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more songs");
                }
                return snapshot.get(index++);
            }
        };
    }
}
