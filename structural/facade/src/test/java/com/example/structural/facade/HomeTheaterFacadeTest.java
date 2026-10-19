package com.example.structural.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeTheaterFacadeTest {
    @Test
    void facadeStartsAndStopsSubsystemTogether() {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        MediaPlayer player = new MediaPlayer();
        HomeTheaterFacade theater = new HomeTheaterFacade(amplifier, projector, player);

        theater.watchMovie("Metropolis");

        assertEquals("movie", amplifier.mode());
        assertTrue(projector.isOn());
        assertEquals("Metropolis", player.playingTitle());

        theater.endMovie();

        assertEquals("off", amplifier.mode());
        assertFalse(projector.isOn());
        assertNull(player.playingTitle());
    }

    @Test
    void invalidMovieTitleIsRejected() {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        MediaPlayer player = new MediaPlayer();
        HomeTheaterFacade theater = new HomeTheaterFacade(amplifier, projector, player);

        assertThrows(IllegalArgumentException.class, () -> theater.watchMovie(" "));
        assertEquals("off", amplifier.mode());
        assertFalse(projector.isOn());
        assertNull(player.playingTitle());
    }

    @Test
    void requiresAllSubsystems() {
        assertThrows(
                NullPointerException.class,
                () -> new HomeTheaterFacade(new Amplifier(), null, new MediaPlayer()));
    }
}
