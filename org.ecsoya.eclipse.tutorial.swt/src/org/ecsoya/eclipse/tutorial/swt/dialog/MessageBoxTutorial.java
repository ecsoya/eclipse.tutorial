package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MessageBoxTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		MessageBox box = new MessageBox(shell, SWT.RETRY | SWT.IGNORE
				| SWT.ABORT | SWT.ICON_QUESTION);
		box.setText("Foxes vs. Dogs");
		box.setMessage("A quick brown fox jumps over the lazy dog?");
		int result = box.open();

		display.dispose();
	}
}
