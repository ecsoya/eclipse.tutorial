package org.ecsoya.eclipse.tutorial.swt.shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ShellTutorial1 {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display, SWT.NO_TRIM);
		shell.setLayout(new RowLayout());
		shell.setSize(300, 200);

		Button button = new Button(shell, SWT.NONE);
		button.setText("Close");
		button.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
