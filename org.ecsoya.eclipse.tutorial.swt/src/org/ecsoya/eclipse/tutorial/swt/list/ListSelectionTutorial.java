package org.ecsoya.eclipse.tutorial.swt.list;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ListSelectionTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("List Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Text text = new Text(shell, SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final List list = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		list.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		for (int i = 0; i < 5; i++) {
			list.add("multi-selection-" + i);
		}
		list.select(2, 3);
		list.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selection = list.getSelection();
				text.setText("Selected items: " + Arrays.toString(selection));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selection = list.getSelection();
				text.setText(text.getText() + "\nDouble clicked on: "
						+ Arrays.toString(selection));
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
