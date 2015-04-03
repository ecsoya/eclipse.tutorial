package org.ecsoya.eclipse.tutorial.swt.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CompositeTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Composite Tutorial");

		Composite composite = new Composite(shell, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);

		composite.setBounds(10, 10, 100, 100);
		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
