package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PrintDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		PrintDialog dialog = new PrintDialog(shell);
		dialog.setStartPage(1);
		dialog.setEndPage(3);
		dialog.setPrintToFile(true);
		dialog.open();

		display.dispose();
	}

}
