package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;

public class FontDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);

		FontDialog dialog = new FontDialog(shell);
		dialog.setEffectsVisible(true);
		FontData open = dialog.open();

		display.dispose();
	}

}
