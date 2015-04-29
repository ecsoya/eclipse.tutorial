package org.ecsoya.eclipse.tutorial.swt.layout;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableLayoutTutorial {

	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		TableColumnLayout layout = new TableColumnLayout();
		shell.setLayout(layout);
		Table table = new Table(shell, SWT.BORDER);
		table.setHeaderVisible(true);

		for (int i = 0; i < 3; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + i);
			layout.setColumnData(column, new ColumnWeightData(i + 1));
		}

		shell.setSize(300, 200);
		shell.setText("Table Layout Tutorial");
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
