# Memento

**Intent:** Capture an object's state so it can later be restored, while
keeping the object's implementation details encapsulated.

`NoteEditor` creates opaque `Memento` snapshots and is the only class that can
read their saved text. `History` (the caretaker) stores snapshots without
inspecting them and restores them in last-in-first-out order.

```java
var editor = new NoteEditor();
var history = new NoteEditor.History();
editor.write("draft");
history.save(editor);
editor.write("published");
history.undo(editor); // "draft"
```

- Implementation: [NoteEditor.java](src/main/java/org/example/behavioral/memento/NoteEditor.java)
- Tests: [NoteEditorTest.java](src/test/java/org/example/behavioral/memento/NoteEditorTest.java)

Memento is useful for undo, checkpoints, and transactional rollback. Full
snapshots may consume substantial memory; large or mutable object graphs need
careful copying, versioning, and retention policies.
