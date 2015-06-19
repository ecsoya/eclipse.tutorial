package org.ecsoya.eclipse.tutorial.actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class SampleToolBarContribution extends
		WorkbenchWindowControlContribution {
	public SampleToolBarContribution() {
	}

	public SampleToolBarContribution(String id) {
		super(id);
	}

	protected Control createControl(Composite parent) {
		Combo combo = new Combo(parent, SWT.READ_ONLY);
		for (int i = 0; i < 5; i++) {
			combo.add("Ecsoya sample item " + i);
		}
		combo.select(2);
		return combo;
	}
}
