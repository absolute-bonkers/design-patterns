package org.example.behavioral.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class PlaylistTest {
    @Test
    void iteratorTraversesInsertionOrderAndIsolatesItsSnapshot() {
        var playlist = new Playlist();
        playlist.add("First");
        var iterator = playlist.iterator();
        playlist.add("Second");

        assertEquals("First", iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals(java.util.List.of("First", "Second"), java.util.stream.StreamSupport
                .stream(playlist.spliterator(), false).toList());
    }

    @Test
    void nextPastEndThrows() {
        assertThrows(NoSuchElementException.class, () -> new Playlist().iterator().next());
    }
}
