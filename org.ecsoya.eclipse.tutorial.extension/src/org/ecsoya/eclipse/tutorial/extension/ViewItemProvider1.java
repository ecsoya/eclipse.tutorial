package org.ecsoya.eclipse.tutorial.extension;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.ecsoya.eclipse.tutorial.extensionpoints.views.IViewItemProvider;

public class ViewItemProvider1 implements IViewItemProvider {

	@Override
	public void contributeItemsFor(Table table) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "Contribute Item",
				"This item is contributed by plugin: org.ecsoya.eclipse.tutorial.extension" });
	}

}
