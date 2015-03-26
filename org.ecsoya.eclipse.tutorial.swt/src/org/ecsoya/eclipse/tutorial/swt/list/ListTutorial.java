package org.ecsoya.eclipse.tutorial.swt.list;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ListTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("List Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		List list1 = new List(shell, SWT.SINGLE | SWT.BORDER);
		for (int i = 0; i < 5; i++) {
			list1.add("single-selection-" + i);
		}
		list1.select(2);

		List list2 = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		list2.setLayoutData(new RowData(SWT.DEFAULT, 60));
		for (int i = 0; i < 5; i++) {
			list2.add("multi-selection-" + i);
		}
		list2.select(2, 3);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
