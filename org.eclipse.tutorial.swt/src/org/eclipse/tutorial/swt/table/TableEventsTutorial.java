package org.eclipse.tutorial.swt.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableEventsTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Table Events Tutorial");
		shell.setSize(400, 400);

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		final Text label = new Text(shell, SWT.V_SCROLL | SWT.WRAP);

		final Table table = new Table(shell, SWT.BORDER | SWT.CHECK
				| SWT.FULL_SELECTION);

		Image taskImage = new Image(display,
				TableEventsTutorial.class.getResourceAsStream("task.gif"));

		TableColumn nameColumn = new TableColumn(table, SWT.CENTER);
		nameColumn.setText("Name");
		nameColumn.setWidth(180);
		nameColumn.setImage(taskImage);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Image helpImage = new Image(display,
				TableEventsTutorial.class.getResourceAsStream("help.gif"));

		TableColumn optionColumn = new TableColumn(table, SWT.CENTER);
		optionColumn.setText("Option");
		optionColumn.setWidth(180);
		optionColumn.setImage(helpImage);

		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table, SWT.CENTER);
			item.setText(0, "item-name- " + i);
			item.setText(1, "item-option- " + i);
			item.setImage(0, taskImage);
			item.setImage(1, helpImage);
		}

		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = e.detail == SWT.CHECK ? " Checked"
						: " Selected";
				label.append("\n" + e.item + string);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				label.append("\nDouble clicked on " + e.item);
			}
		});

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
