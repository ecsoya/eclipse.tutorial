package org.eclipse.tutorial.swt.datetime;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DateTimeTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("DateTime Tutorial");

		shell.setLayout(new GridLayout(2, false));

		new Label(shell, SWT.NONE).setText("Date: ");
		new DateTime(shell, SWT.DATE);
		new Label(shell, SWT.NONE).setText("Date(Long): ");
		new DateTime(shell, SWT.DATE | SWT.LONG);
		new Label(shell, SWT.NONE).setText("Date(Medium): ");
		new DateTime(shell, SWT.DATE | SWT.MEDIUM);
		new Label(shell, SWT.NONE).setText("Date(Short): ");
		new DateTime(shell, SWT.DATE | SWT.SHORT);

		new Label(shell, SWT.NONE).setText("Date(Drop Down): ");
		new DateTime(shell, SWT.DATE | SWT.DROP_DOWN);

		new Label(shell, SWT.NONE).setText("Time: ");
		new DateTime(shell, SWT.TIME);
		new Label(shell, SWT.NONE).setText("Time(Short): ");
		new DateTime(shell, SWT.TIME | SWT.SHORT);

		new Label(shell, SWT.NONE).setText("Calendar: ");
		new DateTime(shell, SWT.CALENDAR);

		shell.open();
		shell.pack();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
