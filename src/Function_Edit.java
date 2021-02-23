import javax.swing.JEditorPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

public class Function_Edit {
       Main gui;
public Function_Edit(Main gui) {
	this.gui = gui;
}
//undo method
public void undo(){
	gui.um.undo();
}
//redo method
public void redo() {
		gui.um.redo();
	}
//copy method
public void copy() {
	gui.textarea.copy();
}
//cut method
public void cut() {
	gui.textarea.cut();
}
//paste method
public void paste() {
	gui.textarea.paste();
}
}

