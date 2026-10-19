# Command

**Intent:** Turn an operation into an object. The invoker can execute,
queue, log, or undo it without knowing how the receiver performs the work.

`TextEditor.InsertText` holds a document, insertion point, and text. It knows
both how to execute and reverse the change. `History` is the invoker and keeps
successful commands on a stack. For example:

```java
var document = new TextEditor.Document();
var history = new TextEditor.History();
history.execute(new TextEditor.InsertText(document, 0, "Hello"));
history.undo(); // document is empty again
```

- Implementation: [TextEditor.java](src/main/java/org/example/behavioral/command/TextEditor.java)
- Tests: [TextEditorTest.java](src/test/java/org/example/behavioral/command/TextEditorTest.java)

Commands are useful for undo/redo, job queues, macro recording, and deferred
execution. They add types and state for each operation; correct undo also
requires retaining enough information and handling failures or external side
effects carefully.
