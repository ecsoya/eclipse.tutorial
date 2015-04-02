package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DirectoryDialogTutorial {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);

		DirectoryDialog dialog = new DirectoryDialog(shell);
		dialog.setText("Foxes vs. Dogs");
		dialog.setMessage("A qiuick brown fox jumps over the laze dog.");
		dialog.setFilterPath("C:");
		String open = dialog.open();
		System.out.println(open);
		display.dispose();

	}

}
