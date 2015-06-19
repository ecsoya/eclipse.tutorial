package org.ecsoya.eclipse.tutorial.extensionpoints.views;

import org.eclipse.swt.widgets.Table;

public interface IViewItemProvider {

	void contributeItemsFor(Table table);
}
