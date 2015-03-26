package org.ecsoya.eclipse.tutorial.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Table Tutorial");
		shell.setSize(400, 200);

		GridLayout layout = new GridLayout(2, true);
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 0;
		shell.setLayout(layout);

		new Label(shell, SWT.NONE).setText("Table with default style");
		new Label(shell, SWT.NONE).setText("Table with SWT.CHECK style");

		// Table with default style
		Table table1 = new Table(shell, SWT.BORDER);
		table1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image taskImage = new Image(display,
				TableTutorial.class.getResourceAsStream("task.gif"));
		// Add 5 table items.
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table1, SWT.CENTER);
			item.setText("default-item " + i);
			item.setImage(taskImage);
		}

		// Add table column
		TableColumn nameColumn = new TableColumn(table1, SWT.CENTER);
		nameColumn.setText("Name");
		nameColumn.setWidth(100);
		nameColumn.setImage(taskImage);

		// Make herder visible
		table1.setHeaderVisible(true);

		// Table with SWT.CHECK style
		Table table2 = new Table(shell, SWT.CHECK | SWT.BORDER);
		table2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image helpImage = new Image(display,
				TableTutorial.class.getResourceAsStream("help.gif"));

		// Add 5 table items.
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table2, SWT.CENTER);
			item.setText("check-item " + i);
			item.setImage(helpImage);
		}

		// Add table column
		TableColumn optionColumn = new TableColumn(table2, SWT.CENTER);
		optionColumn.setText("Option");
		optionColumn.setWidth(120);
		optionColumn.setImage(helpImage);

		// Make herder visible
		table2.setHeaderVisible(true);
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
