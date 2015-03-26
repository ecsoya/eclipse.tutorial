package org.ecsoya.eclipse.tutorial.swt.scale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;

public class ScaleSelectionTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Scale Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Scale scale = new Scale(shell, SWT.HORIZONTAL);
		scale.setMaximum(100);
		scale.setPageIncrement(10);
		scale.setIncrement(5);
		scale.setSelection(20);
		scale.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				label.setText("Selection: " + scale.getSelection());
			}
		});
		scale.setFocus();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
