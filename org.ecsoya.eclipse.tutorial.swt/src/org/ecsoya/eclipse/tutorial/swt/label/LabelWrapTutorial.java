package org.ecsoya.eclipse.tutorial.swt.label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelWrapTutorial {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Label Wrap Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(2, true));

		Label noWrapLabel = new Label(shell, SWT.BORDER);
		noWrapLabel.setText("This is a long Text on label, but no WRAP style set.");
		noWrapLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		
		Label wrapLabel = new Label(shell, SWT.WRAP | SWT.BORDER);
		wrapLabel.setText("This is a long Text on label, and the WRAP style is set.");
		wrapLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));


		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
