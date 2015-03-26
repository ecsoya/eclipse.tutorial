package org.ecsoya.eclipse.tutorial.swt.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ToolBarWithComboTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ToolBar with Combo Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		final Image taskImage = new Image(display,
				ToolBarWithComboTutorial.class.getResourceAsStream("task.gif"));

		ToolBar toolBar = new ToolBar(shell, SWT.HORIZONTAL | SWT.FLAT);
		new ToolItem(toolBar, SWT.PUSH).setImage(taskImage);
		new ToolItem(toolBar, SWT.PUSH).setImage(taskImage);

		// 1. Only SWT.SEPARATOR can fill with a Control.
		ToolItem item = new ToolItem(toolBar, SWT.SEPARATOR);
		Combo combo = new Combo(toolBar, SWT.BORDER);
		for (int i = 0; i < 5; i++) {
			combo.add("item - " + i);
		}
		combo.select(2);
		item.setControl(combo);

		// 2. The width of item should be set to the minimum width of the
		// control, otherwise, the default value of a separator will be used.
		Point size = combo.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		item.setWidth(size.x);

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
