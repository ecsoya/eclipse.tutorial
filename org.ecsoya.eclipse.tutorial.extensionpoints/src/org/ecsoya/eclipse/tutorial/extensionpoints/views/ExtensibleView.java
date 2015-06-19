package org.ecsoya.eclipse.tutorial.extensionpoints.views;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

public class ExtensibleView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.ecsoya.eclipse.tutorial.extensionpoints.views.ExtensibleView";

	private Table table;

	public void createPartControl(Composite parent) {
		Composite tableOwner = new Composite(parent, SWT.NONE);
		TableColumnLayout layout = new TableColumnLayout();
		tableOwner.setLayout(layout);
		table = new Table(tableOwner, SWT.FULL_SELECTION | SWT.BORDER
				| SWT.V_SCROLL);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText("Name");
		layout.setColumnData(column1, new ColumnWeightData(1));

		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText("Description");
		layout.setColumnData(column2, new ColumnWeightData(3));

		// create items
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { "Internal item " + i,
					"Description for internal item " + i });
		}

		contributeItems();
	}

	private void contributeItems() {
		if (table == null || table.isDisposed()) {
			return;
		}
		IViewItemProvider[] providers = ExtensibleUtilities
				.getViewItemProviders();
		for (IViewItemProvider p : providers) {
			p.contributeItemsFor(table);
		}
	}

	public void setFocus() {
		if (table != null && !table.isDisposed()) {
			table.setFocus();
		}
	}

}