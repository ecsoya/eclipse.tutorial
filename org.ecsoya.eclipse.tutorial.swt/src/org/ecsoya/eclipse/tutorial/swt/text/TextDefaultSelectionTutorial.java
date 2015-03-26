package org.ecsoya.eclipse.tutorial.swt.text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextDefaultSelectionTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Text Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		final Text text1 = new Text(shell, SWT.BORDER);
		text1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		text1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Never called for text.
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				label.setText("Enter pressed: " + text1.getText());
			}
		});

		final Text text2 = new Text(shell, SWT.SEARCH | SWT.ICON_SEARCH);
		text2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		text2.setMessage("type message for search");
		text2.addListener(SWT.DefaultSelection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				label.setText("Enter pressed to perform search : "
						+ text2.getText());
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
