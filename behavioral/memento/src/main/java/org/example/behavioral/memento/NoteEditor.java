package org.example.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Optional;

/** The editor owns its state; snapshots can be restored without exposing it. */
public final class NoteEditor {
    private String text = "";

    public void write(String text) {
        this.text = Objects.requireNonNull(text, "text");
    }

    public String text() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = Objects.requireNonNull(memento, "memento").savedText;
    }

    public static final class Memento {
        private final String savedText;

        private Memento(String savedText) {
            this.savedText = savedText;
        }
    }

    /** Caretaker stores snapshots without inspecting their contents. */
    public static final class History {
        private final Deque<Memento> snapshots = new ArrayDeque<>();

        public void save(NoteEditor editor) {
            snapshots.push(Objects.requireNonNull(editor, "editor").save());
        }

        public boolean undo(NoteEditor editor) {
            if (snapshots.isEmpty()) {
                return false;
            }
            Objects.requireNonNull(editor, "editor").restore(snapshots.pop());
            return true;
        }
    }
}
