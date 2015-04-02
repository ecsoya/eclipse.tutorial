package org.ecsoya.eclipse.tutorial.swt.expandbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ExpandBarTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("ExpandBar Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		final Image taskImage = new Image(display,
				ExpandBarTutorial.class.getResourceAsStream("task.gif"));

		ExpandBar expandBar = new ExpandBar(shell, SWT.NONE);

		ExpandItem item1 = new ExpandItem(expandBar, SWT.NONE);
		item1.setText("Expanded item");
		Composite control = new Composite(expandBar, SWT.NONE);
		control.setLayout(new RowLayout(SWT.VERTICAL));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_INFORMATION));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_ERROR));
		item1.setControl(control);
		item1.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item1.setExpanded(true);
		item1.setImage(taskImage);

		ExpandItem item2 = new ExpandItem(expandBar, SWT.NONE);
		item2.setText("Collapsed item");
		control = new Composite(expandBar, SWT.NONE);
		control.setLayout(new RowLayout(SWT.VERTICAL));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_WORKING));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_QUESTION));
		item2.setControl(control);
		item2.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item2.setImage(taskImage);

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
