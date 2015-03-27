package org.ecsoya.eclipse.tutorial.swt.progressbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarTutorial {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ProgressBar Tutorial");
		shell.setSize(315, 200);

		shell.setLayout(new GridLayout(2, false));

		// SWT.DEFAULT | SWT.SMOOTH
		final ProgressBar smoothBar = new ProgressBar(shell, SWT.SMOOTH);
		smoothBar.setMaximum(100);
		smoothBar.setSelection(30);

		new Label(shell, SWT.NONE).setText("SWT.SMOOTH");

		// SWT.INDETERMINATE
		new ProgressBar(shell, SWT.INDETERMINATE);
		new Label(shell, SWT.NONE).setText("SWT.INDETERMINATE");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
