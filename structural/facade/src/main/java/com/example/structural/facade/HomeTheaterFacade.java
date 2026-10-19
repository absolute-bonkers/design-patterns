package com.example.structural.facade;

import java.util.Objects;

public final class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final Projector projector;
    private final MediaPlayer player;

    public HomeTheaterFacade(Amplifier amplifier, Projector projector, MediaPlayer player) {
        this.amplifier = Objects.requireNonNull(amplifier, "amplifier");
        this.projector = Objects.requireNonNull(projector, "projector");
        this.player = Objects.requireNonNull(player, "player");
    }

    public void watchMovie(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        amplifier.setMode("movie");
        projector.turnOn();
        player.play(title);
    }

    public void endMovie() {
        player.stop();
        projector.turnOff();
        amplifier.setMode("off");
    }
}
