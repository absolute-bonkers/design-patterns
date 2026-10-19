package org.example.behavioral.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TextEditorTest {
    @Test
    void executedCommandsCanBeUndoneInReverseOrder() {
        var document = new TextEditor.Document();
        var history = new TextEditor.History();
        history.execute(new TextEditor.InsertText(document, 0, "Hello"));
        history.execute(new TextEditor.InsertText(document, 5, ", world"));

        assertEquals("Hello, world", document.text());
        assertTrue(history.undo());
        assertEquals("Hello", document.text());
        assertTrue(history.undo());
        assertEquals("", document.text());
        assertFalse(history.undo());
    }

    @Test
    void commandCannotBeUndoneBeforeItRunsOrRunTwice() {
        var command = new TextEditor.InsertText(new TextEditor.Document(), 0, "x");
        assertThrows(IllegalStateException.class, command::undo);
        command.execute();
        assertThrows(IllegalStateException.class, command::execute);
    }
}
