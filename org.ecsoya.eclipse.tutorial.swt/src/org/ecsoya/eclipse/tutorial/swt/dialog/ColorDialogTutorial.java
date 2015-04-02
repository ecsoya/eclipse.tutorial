package org.ecsoya.eclipse.tutorial.swt.dialog;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ColorDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell();

		ColorDialog dialog = new ColorDialog(shell);
		dialog.setRGB(new RGB(0, 125, 0));
		System.out.println(dialog.open());
		display.dispose();
	}

}
