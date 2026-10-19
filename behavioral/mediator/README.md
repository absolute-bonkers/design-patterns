# Mediator

**Intent:** Centralize complex communication between collaborating objects
so participants do not hold direct references to every other participant.

`ChatRoom` is the mediator. Participants join it and send through it; the room
broadcasts each message to every other member. The sender's inbox is not
modified, and a participant cannot send before joining.

```java
var room = new ChatRoom();
var ada = new ChatRoom.Participant("Ada");
var lin = new ChatRoom.Participant("Lin");
room.join(ada);
room.join(lin);
ada.send("Hello, Lin");
```

- Implementation: [ChatRoom.java](src/main/java/org/example/behavioral/mediator/ChatRoom.java)
- Tests: [ChatRoomTest.java](src/test/java/org/example/behavioral/mediator/ChatRoomTest.java)

Mediators are useful in chat systems, UI dialog coordination, and workflow
orchestration. They reduce many-to-many coupling, but can become a
"god object" if they absorb too much policy; split responsibilities when
coordination grows.
