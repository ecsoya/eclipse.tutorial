package org.ecsoya.eclipse.tutorial.jface.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TitleAreaDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		TitleAreaDialog dialog = new TitleAreaDialog(shell) {
			protected void configureShell(Shell newShell) {
				super.configureShell(newShell);
				newShell.setText("TitleAreaDialog Tutorial");
			}

			protected Control createDialogArea(Composite parent) {
				Composite dialogArea = (Composite) super
						.createDialogArea(parent);
				// add your contents here
				setTitle("Add yout TITLE here");
				setMessage("Add your MESSAGE here");
				return dialogArea;
			}
		};
		dialog.open();
		display.dispose();
	}

}
