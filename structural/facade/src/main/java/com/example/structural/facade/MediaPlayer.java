package com.example.structural.facade;

public final class MediaPlayer {
    private String playingTitle;

    public void play(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        playingTitle = title;
    }

    public void stop() {
        playingTitle = null;
    }

    public String playingTitle() {
        return playingTitle;
    }
}
