package org.eclipse.tutorial.swt.tree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class TreeTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Tree Tutorial");
		shell.setSize(400, 300);

		GridLayout layout = new GridLayout(2, true);
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 0;
		shell.setLayout(layout);

		new Label(shell, SWT.NONE).setText("Tree with default style");
		new Label(shell, SWT.NONE).setText("Tree with SWT.CHECK style");

		// Tree with default style
		Tree tree1 = new Tree(shell, SWT.BORDER);
		tree1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image taskImage = new Image(display,
				TreeTutorial.class.getResourceAsStream("task.gif"));
		// Add 5 Tree items.
		for (int i = 0; i < 5; i++) {
			TreeItem item = new TreeItem(tree1, SWT.CENTER);
			item.setText("default-item " + i);
			item.setImage(taskImage);

			// Add 5 sub item.
			for (int j = 0; j < 5; j++) {
				TreeItem subItem = new TreeItem(item, SWT.LEFT);
				subItem.setText("sub-item " + i + j);
				subItem.setImage(taskImage);
			}
			if (i == 3) {
				item.setExpanded(true);
			}
		}

		// Add Tree column
		TreeColumn nameColumn = new TreeColumn(tree1, SWT.CENTER);
		nameColumn.setText("Name");
		nameColumn.setImage(taskImage);
		nameColumn.setWidth(160);

		// Make herder visible
		tree1.setHeaderVisible(true);

		// Tree with SWT.CHECK style
		Tree tree2 = new Tree(shell, SWT.CHECK | SWT.BORDER);
		tree2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image helpImage = new Image(display,
				TreeTutorial.class.getResourceAsStream("help.gif"));

		// Add 5 Tree items.
		for (int i = 0; i < 5; i++) {
			TreeItem item = new TreeItem(tree2, SWT.CENTER);
			item.setText("check-item " + i);
			item.setImage(helpImage);

			// Add 5 sub item.
			for (int j = 0; j < 5; j++) {
				TreeItem subItem = new TreeItem(item, SWT.LEFT);
				subItem.setText("sub-item " + i + j);
				subItem.setImage(helpImage);
				subItem.setChecked(true);
			}
			if (i == 0) {
				item.setExpanded(true);
			}
		}

		// Add Tree column
		TreeColumn optionColumn = new TreeColumn(tree2, SWT.CENTER);
		optionColumn.setText("Option");
		optionColumn.setWidth(160);
		optionColumn.setImage(helpImage);

		// Make herder visible
		tree2.setHeaderVisible(true);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		helpImage.dispose();
		display.dispose();
	}
}
