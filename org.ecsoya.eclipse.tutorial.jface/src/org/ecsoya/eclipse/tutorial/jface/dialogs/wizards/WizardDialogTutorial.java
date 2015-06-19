package org.ecsoya.eclipse.tutorial.jface.dialogs.wizards;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class WizardDialogTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		WizardDialog dialog = new WizardDialog(shell, new MyWizard());

		dialog.open();

		display.dispose();
	}

}
