package org.ecsoya.eclipse.tutorial.swt.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ToolBarSeparatorTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ToolBar Separator Tutorial");
		shell.setSize(400, 400);

		shell.setLayout(new GridLayout());
		final Image taskImage = new Image(display,
				ToolBarTutorial.class.getResourceAsStream("task.gif"));
		ToolBar toolBar = new ToolBar(shell, SWT.HORIZONTAL | SWT.FLAT);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				ToolItem toolItem = new ToolItem(toolBar, SWT.RADIO);
				toolItem.setImage(taskImage);
				toolItem.setText("item " + i + "" + j);
				toolItem.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {

					}
				});
			}
			new ToolItem(toolBar, SWT.SEPARATOR);
		}

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
