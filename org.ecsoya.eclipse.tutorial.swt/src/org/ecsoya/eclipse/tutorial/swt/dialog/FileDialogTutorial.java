package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class FileDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		FileDialog openDialog = new FileDialog(shell, SWT.OPEN | SWT.MULTI);
		openDialog.setText("Open File Dialog");
		openDialog.setFilterExtensions(new String[] { "*.jpg;*.png;*.gif",
				"*.*" });
		openDialog.setFilterPath("C:");
		String open = openDialog.open();

		FileDialog saveDialog = new FileDialog(shell, SWT.SAVE);
		saveDialog.setText("Save File Dialog");
		saveDialog.setFilterExtensions(new String[] { "*.txt" });
		saveDialog.setFileName("new_file");
		saveDialog.setFilterPath("C:");

		saveDialog.setOverwrite(true);
		saveDialog.open();

		display.dispose();
	}

}
