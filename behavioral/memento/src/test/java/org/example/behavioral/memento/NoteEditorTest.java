package org.example.behavioral.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NoteEditorTest {
    @Test
    void restoresEarlierSnapshotsInReverseOrder() {
        var editor = new NoteEditor();
        var history = new NoteEditor.History();
        editor.write("draft");
        history.save(editor);
        editor.write("published");
        history.save(editor);
        editor.write("unsaved change");

        assertTrue(history.undo(editor));
        assertEquals("published", editor.text());
        assertTrue(history.undo(editor));
        assertEquals("draft", editor.text());
        assertFalse(history.undo(editor));
    }

    @Test
    void directSnapshotRestorationReturnsToCapturedState() {
        var editor = new NoteEditor();
        editor.write("before");
        var snapshot = editor.save();
        editor.write("after");

        editor.restore(snapshot);

        assertEquals("before", editor.text());
    }
}
