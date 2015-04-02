package org.ecsoya.eclipse.tutorial.swt.taskbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TaskBar;
import org.eclipse.swt.widgets.TaskItem;

public class TaskBarTutorial {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("TaskBar Tutorial");
		shell.setSize(315, 200);

		shell.setLayout(new GridLayout(2, false));

		TaskBar taskBar = display.getSystemTaskBar();

		TaskItem item = taskBar.getItem(shell);
		if (item == null) {
			item = taskBar.getItem(null);
		}
		item.setOverlayImage(display.getSystemImage(SWT.ICON_ERROR));
		item.setOverlayText("OK");

		item.setProgress(50);
		item.setProgressState(SWT.PAUSED);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
