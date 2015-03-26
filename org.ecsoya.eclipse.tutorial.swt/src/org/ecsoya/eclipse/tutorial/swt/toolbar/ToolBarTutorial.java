package org.ecsoya.eclipse.tutorial.swt.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ToolBarTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ToolBar Tutorial");
		shell.setSize(400, 400);

		shell.setLayout(new GridLayout());

		Group group1 = new Group(shell, SWT.NONE);
		group1.setText("Horizontal ToolBar");
		group1.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		group1.setLayout(new GridLayout());

		final Image taskImage = new Image(display,
				ToolBarTutorial.class.getResourceAsStream("task.gif"));

		// Create a horizontal ToolBar.
		final ToolBar hToolBar = new ToolBar(group1, SWT.HORIZONTAL | SWT.FLAT
				| SWT.SHADOW_OUT);
		new ToolItem(hToolBar, SWT.PUSH).setText("Push");// Push style item.
		new ToolItem(hToolBar, SWT.SEPARATOR);// Separator, show only parent
												// style contains 'SWT.FLAT'
		new ToolItem(hToolBar, SWT.CHECK).setText("Check1"); // Check style item
		new ToolItem(hToolBar, SWT.CHECK).setText("Check2"); // Check style item
		new ToolItem(hToolBar, SWT.SEPARATOR);
		new ToolItem(hToolBar, SWT.RADIO).setText("Radio1"); // Radio style item
		new ToolItem(hToolBar, SWT.RADIO).setText("Radio2"); // Radop style item
		new ToolItem(hToolBar, SWT.SEPARATOR);

		// Create Drop down style item,
		final ToolItem dropDown = new ToolItem(hToolBar, SWT.DROP_DOWN);
		dropDown.setText("Drop Down");
		// Create a menu to show when the drop down item is expand.
		final Menu menu = new Menu(shell, SWT.POP_UP);
		for (int i = 0; i < 5; i++) {
			MenuItem menuItem = new MenuItem(menu, SWT.NONE);
			menuItem.setImage(taskImage);
			menuItem.setText("Item " + i);
		}
		// Add listener to show the menu for drop down item.
		dropDown.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (SWT.ARROW == event.detail) {
					Rectangle rect = dropDown.getBounds();
					Point pt = new Point(rect.x, rect.y + rect.height);
					pt = hToolBar.toDisplay(pt);
					menu.setLocation(pt.x, pt.y);
					menu.setVisible(true);
				}
			}
		});

		ToolItem[] tools = hToolBar.getItems();
		for (ToolItem toolItem : tools) {
			toolItem.setImage(taskImage);
		}

		Group group2 = new Group(shell, SWT.NONE);
		group2.setText("Vertical ToolBar");
		group2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		group2.setLayout(new GridLayout());

		// Create a vertical ToolBar.
		ToolBar vToolBar = new ToolBar(group2, SWT.VERTICAL | SWT.SHADOW_OUT
				| SWT.RIGHT);// SWT.RIGHT makes text to display at right of
								// image.
		new ToolItem(vToolBar, SWT.PUSH).setText("Push");
		new ToolItem(vToolBar, SWT.SEPARATOR);
		new ToolItem(vToolBar, SWT.CHECK).setText("Check1");
		new ToolItem(vToolBar, SWT.CHECK).setText("Check2");
		new ToolItem(vToolBar, SWT.SEPARATOR);
		new ToolItem(vToolBar, SWT.RADIO).setText("Radio1");
		new ToolItem(vToolBar, SWT.RADIO).setText("Radio2");
		new ToolItem(vToolBar, SWT.SEPARATOR);
		new ToolItem(vToolBar, SWT.DROP_DOWN).setText("Drop Down");
		ToolItem[] items = vToolBar.getItems();
		for (ToolItem toolItem : items) {
			toolItem.setImage(taskImage);
		}

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		display.dispose();
	}

}
