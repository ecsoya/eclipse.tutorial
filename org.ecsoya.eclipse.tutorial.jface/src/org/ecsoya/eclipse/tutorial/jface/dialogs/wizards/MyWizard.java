package org.ecsoya.eclipse.tutorial.jface.dialogs.wizards;

import org.eclipse.jface.wizard.Wizard;

public class MyWizard extends Wizard {
	public MyWizard() {
		setWindowTitle("Wizard Dialog Tutorial");
	}

	public void addPages() {
		addPage(new WizardPage1());
	}

	public boolean performFinish() {
		return false;
	}
}
