package org.ecsoya.eclipse.tutorial.swt.sash;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Shell;

public class SashTutorial {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("Sash Tutorial");
		shell.setSize(315, 200);

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		// SWT.HORIZONTAL | SWT.SMOOTH
		Group group1 = new Group(shell, SWT.NONE);
		group1.setText("Horizontal && Smooth");

		final Sash hSash = new Sash(group1, SWT.HORIZONTAL | SWT.SMOOTH);
		Rectangle rect = group1.getClientArea();
		hSash.setBounds(rect.x, 40, 315, 10);
		hSash.setBackground(display.getSystemColor(SWT.COLOR_RED));

		// SWT.VERTICAL
		Group group2 = new Group(shell, SWT.NONE);
		group2.setText("Vertical");

		final Sash vSash = new Sash(group2, SWT.VERTICAL);
		Rectangle r = group2.getClientArea();
		vSash.setBounds(150, r.y, 20, 100);
		vSash.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event e) {
				vSash.setBounds(e.x, e.y, e.width, e.height);
			}
		});
		vSash.setBackground(display.getSystemColor(SWT.COLOR_GRAY));

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
