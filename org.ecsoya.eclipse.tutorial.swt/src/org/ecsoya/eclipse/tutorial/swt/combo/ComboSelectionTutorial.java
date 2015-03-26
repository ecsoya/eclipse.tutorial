package org.ecsoya.eclipse.tutorial.swt.combo;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ComboSelectionTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Combo Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());
		
		final Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		final Combo dropDown = new Combo(shell, SWT.DROP_DOWN);
		dropDown.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		for (int i = 0; i < 5; i++) {
			dropDown.add("drop-down -" + i);
		}
		dropDown.select(2);
		dropDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				label.setText("Selected: " + dropDown.getItem(dropDown.getSelectionIndex()));
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
