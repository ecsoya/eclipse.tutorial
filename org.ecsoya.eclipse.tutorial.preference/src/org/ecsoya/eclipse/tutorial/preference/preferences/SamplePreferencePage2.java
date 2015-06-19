package org.ecsoya.eclipse.tutorial.preference.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.ecsoya.eclipse.tutorial.preference.Activator;

public class SamplePreferencePage2 extends PreferencePage implements
		IWorkbenchPreferencePage {
	public SamplePreferencePage2() {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	public void init(IWorkbench workbench) {
	}

	protected Control createContents(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Page 2");
		return label;
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
	}

	@Override
	protected void performApply() {
		super.performApply();
	}
}
