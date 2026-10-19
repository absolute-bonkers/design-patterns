package org.example.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** Text editing commands encapsulate both an action and its inverse. */
public final class TextEditor {
    private TextEditor() {}

    public static final class Document {
        private final StringBuilder text = new StringBuilder();

        public String text() {
            return text.toString();
        }

        private void insert(int offset, String value) {
            text.insert(offset, value);
        }

        private void delete(int offset, int length) {
            text.delete(offset, offset + length);
        }
    }

    public interface Command {
        void execute();

        void undo();
    }

    public static final class InsertText implements Command {
        private final Document document;
        private final int offset;
        private final String value;
        private boolean executed;

        public InsertText(Document document, int offset, String value) {
            this.document = Objects.requireNonNull(document, "document");
            this.offset = offset;
            this.value = Objects.requireNonNull(value, "value");
        }

        @Override
        public void execute() {
            if (executed) {
                throw new IllegalStateException("Command has already been executed");
            }
            document.insert(offset, value);
            executed = true;
        }

        @Override
        public void undo() {
            if (!executed) {
                throw new IllegalStateException("Cannot undo a command that has not run");
            }
            document.delete(offset, value.length());
            executed = false;
        }
    }

    public static final class History {
        private final Deque<Command> undoStack = new ArrayDeque<>();

        public void execute(Command command) {
            Objects.requireNonNull(command, "command").execute();
            undoStack.push(command);
        }

        public boolean undo() {
            if (undoStack.isEmpty()) {
                return false;
            }
            undoStack.pop().undo();
            return true;
        }
    }
}
