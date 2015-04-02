package org.ecsoya.eclipse.tutorial.swt.tray;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class TrayTutorial {

	public static void main(String[] args) {

		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Tray Tutorial");
		shell.setSize(300, 200);

		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.spacing = 0;
		shell.setLayout(layout);

		Image image = new Image(display,
				TrayTutorial.class.getResourceAsStream("task.gif"));

		CLabel label = new CLabel(shell, SWT.CENTER);
		Tray tray = display.getSystemTray();
		if (tray == null) {
			label.setText("This platform does NOT support the tray.");
		} else {
			label.setText("Please visit the icon ");
			new CLabel(shell, SWT.CENTER).setImage(image);
			new CLabel(shell, SWT.CENTER).setText(" on System TaskBar.");
			// Create tray item.
			TrayItem item = new TrayItem(tray, SWT.NONE);
			// Set images.
			item.setImage(image);
			item.setHighlightImage(image);

			// Add tool tip.
			final ToolTip toolTip = new ToolTip(shell, SWT.BALLOON);
			toolTip.setText("Foxes vs. Dogs");
			toolTip.setMessage("A quick brown fox jumps over the lazy dog.");
			item.setToolTip(toolTip);

			// Add Selection and DefaultSelection Listener.
			item.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					shell.moveAbove(null);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					toolTip.setVisible(true);
				}
			});

			// Add Menu Listener.
			final Menu menu = new Menu(shell, SWT.POP_UP);
			for (int i = 0; i < 5; i++) {
				MenuItem menuItem = new MenuItem(menu, SWT.NONE);
				menuItem.setImage(image);
				menuItem.setText("MenuItem - " + i);
			}
			new MenuItem(menu, SWT.SEPARATOR);
			MenuItem exit = new MenuItem(menu, SWT.NONE);
			exit.setText("Exit");
			exit.addListener(SWT.Selection, new Listener() {

				@Override
				public void handleEvent(Event event) {
					shell.dispose();
				}
			});

			item.addMenuDetectListener(new MenuDetectListener() {

				@Override
				public void menuDetected(MenuDetectEvent e) {
					menu.setVisible(true);
				}
			});
		}

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		image.dispose();
		display.dispose();
	}

}
