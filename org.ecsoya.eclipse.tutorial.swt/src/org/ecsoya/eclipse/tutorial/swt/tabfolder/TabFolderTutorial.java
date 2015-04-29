package org.ecsoya.eclipse.tutorial.swt.tabfolder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class TabFolderTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabFolder Tutorial");
		shell.setLayout(new FillLayout());

		TabFolder folder = new TabFolder(shell, SWT.TOP);
		for (int i = 0; i < 3; i++) {
			TabItem item = new TabItem(folder, SWT.NONE);
			item.setText("item " + i);

			Label label = new Label(folder, SWT.NONE);
			label.setText("Add control here.");
			item.setControl(label);
		}
		folder.setSelection(1);

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
