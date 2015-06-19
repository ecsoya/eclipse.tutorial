package org.ecsoya.eclipse.tutorial.jface.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class Dialog1 extends Dialog {

	protected Dialog1(Shell parentShell) {
		super(parentShell);
	}

	protected Control createDialogArea(Composite parent) {
		return super.createDialogArea(parent);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
	}

	protected Point getInitialSize() {
		return super.getInitialSize();
	}

	protected int getShellStyle() {
		return super.getShellStyle();
	}

}
