package org.example.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** The room mediates communication so participants do not depend on one another. */
public final class ChatRoom {
    private final List<Participant> participants = new ArrayList<>();

    public void join(Participant participant) {
        Objects.requireNonNull(participant, "participant");
        if (!participants.contains(participant)) {
            participants.add(participant);
            participant.room = this;
        }
    }

    private void broadcast(Participant sender, String message) {
        if (!participants.contains(sender)) {
            throw new IllegalStateException("Participant must join before sending");
        }
        for (Participant participant : List.copyOf(participants)) {
            if (participant != sender) {
                participant.receive(sender.name + ": " + message);
            }
        }
    }

    public static final class Participant {
        private final String name;
        private final List<String> inbox = new ArrayList<>();
        private ChatRoom room;

        public Participant(String name) {
            this.name = Objects.requireNonNull(name, "name");
        }

        public void send(String message) {
            if (room == null) {
                throw new IllegalStateException("Participant must join before sending");
            }
            room.broadcast(this, Objects.requireNonNull(message, "message"));
        }

        public List<String> inbox() {
            return List.copyOf(inbox);
        }

        private void receive(String message) {
            inbox.add(message);
        }
    }
}
