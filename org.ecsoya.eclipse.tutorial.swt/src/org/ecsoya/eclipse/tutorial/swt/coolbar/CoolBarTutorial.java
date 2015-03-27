package org.ecsoya.eclipse.tutorial.swt.coolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CoolBarTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("CoolBar Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout());

		final Image taskImage = new Image(display,
				CoolBarTutorial.class.getResourceAsStream("task.gif"));

		final CoolBar coolBar = new CoolBar(shell, SWT.HORIZONTAL | SWT.FLAT);

		for (int i = 0; i < 5; i++) {
			CoolItem item = new CoolItem(coolBar, SWT.DROP_DOWN);
			Button control = new Button(coolBar, SWT.NONE);
			control.setImage(taskImage);
			control.setText("Button - " + i);
			item.setControl(control);
			Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			item.setPreferredSize(item.computeSize(size.x, size.y));
		}
		coolBar.setWrapIndices(new int[] { 1, 3 });
		coolBar.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		display.dispose();
	}

}
