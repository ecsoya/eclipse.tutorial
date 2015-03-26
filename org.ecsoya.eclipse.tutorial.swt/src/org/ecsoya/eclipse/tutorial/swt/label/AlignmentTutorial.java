package org.ecsoya.eclipse.tutorial.swt.label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AlignmentTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Alignment Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(3, true));

		Label leftLabel = new Label(shell, SWT.LEFT|SWT.BORDER);
		leftLabel.setText("Left");
		leftLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		Label centerLabel = new Label(shell, SWT.CENTER | SWT.BORDER);
		centerLabel.setText("Center");
		centerLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		Label rightLabel = new Label(shell, SWT.BORDER);
		rightLabel.setText("Right");
		rightLabel.setAlignment(SWT.RIGHT);
		rightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		

		Label imageLeftLabel = new Label(shell, SWT.BORDER);
		imageLeftLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageLeftLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		Label imageCenterLabel = new Label(shell, SWT.BORDER | SWT.CENTER);
		imageCenterLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageCenterLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		Label imageRightLabel = new Label(shell, SWT.BORDER | SWT.RIGHT);
		imageRightLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageRightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
