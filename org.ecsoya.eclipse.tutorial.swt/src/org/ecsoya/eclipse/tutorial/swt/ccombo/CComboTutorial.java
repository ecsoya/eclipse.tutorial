package org.ecsoya.eclipse.tutorial.swt.ccombo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class CComboTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("CCombo Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		Table table = new Table(shell, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setWidth(120);
		column1.setText("Combo");

		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(120);
		column2.setText("CCombo");

		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "combo", "ccombo" });

		TableEditor editor = new TableEditor(table);
		editor.grabHorizontal = true;
		editor.setEditor(new Combo(table, SWT.NONE), item, 0);
		editor = new TableEditor(table);
		editor.grabHorizontal = true;
		editor.setEditor(new CCombo(table, SWT.NONE), item, 1);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
