package org.ecsoya.eclipse.tutorial.jface.dialogs;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class InputDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		InputDialog inputDialog = new InputDialog(shell,
				"Input Dialog Tutorial", "Input value", "Hello World", null);
		inputDialog.open();
		display.dispose();
	}

}
