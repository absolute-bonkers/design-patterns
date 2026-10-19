package org.example.behavioral.mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.behavioral.mediator.ChatRoom.Participant;
import org.junit.jupiter.api.Test;

class ChatRoomTest {
    @Test
    void roomForwardsMessagesToOtherParticipantsOnly() {
        var room = new ChatRoom();
        var ada = new Participant("Ada");
        var lin = new Participant("Lin");
        var kai = new Participant("Kai");
        room.join(ada);
        room.join(lin);
        room.join(kai);

        ada.send("Hello");

        assertEquals(java.util.List.of("Ada: Hello"), lin.inbox());
        assertEquals(java.util.List.of("Ada: Hello"), kai.inbox());
        assertEquals(java.util.List.of(), ada.inbox());
    }

    @Test
    void nonMemberCannotSend() {
        assertThrows(IllegalStateException.class, () -> new Participant("Guest").send("Hi"));
    }
}
