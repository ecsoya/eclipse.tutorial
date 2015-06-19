package org.ecsoya.eclipse.tutorial.jface.dialogs.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class WizardPage1 extends WizardPage {
	protected WizardPage1() {
		super("WizardPage1");
	}

	public void createControl(Composite parent) {
		Label control = new Label(parent, SWT.NONE);
		control.setText("Page1");
		setControl(control);
		setTitle("Page1 Title");
		setMessage("Page1 Message");
	}
}
