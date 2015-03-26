package org.ecsoya.eclipse.tutorial.swt.label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Label Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));
		
		Label textLabel= new Label(shell, SWT.NONE);
	    textLabel.setText("Hello, I am a Label.");

	    Label imageLabel = new Label(shell, SWT.BORDER);
	    imageLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
