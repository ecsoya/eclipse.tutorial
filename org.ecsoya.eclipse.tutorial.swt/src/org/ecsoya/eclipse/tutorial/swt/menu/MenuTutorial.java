package org.ecsoya.eclipse.tutorial.swt.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Menu Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		final Image image = new Image(display,
				MenuTutorial.class.getResourceAsStream("task.gif"));

		// MenuBar
		Menu menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setAccelerator('F');
		fileItem.setImage(image);

		// Drop_Down menu will be set as submenu for File menu.
		Menu fileItemMenu = new Menu(fileItem);
		new MenuItem(fileItemMenu, SWT.PUSH).setText("Open...");
		new MenuItem(fileItemMenu, SWT.PUSH).setText("Exit");
		fileItem.setMenu(fileItemMenu);

		shell.setMenuBar(menuBar);

		Label label = new Label(shell, SWT.NONE);
		label.setText("Popup Menu");

		Menu contextMenu = new Menu(shell, SWT.POP_UP | SWT.NO_RADIO_GROUP);

		MenuItem pushItem = new MenuItem(contextMenu, SWT.PUSH);
		pushItem.setText("Push item");
		pushItem.setImage(image);

		new MenuItem(contextMenu, SWT.SEPARATOR);

		MenuItem checkItem1 = new MenuItem(contextMenu, SWT.CHECK);
		checkItem1.setText("Check item 1");
		checkItem1.setImage(image);
		checkItem1.setSelection(true);

		MenuItem checkItem2 = new MenuItem(contextMenu, SWT.CHECK);
		checkItem2.setText("Check item 2");
		checkItem2.setImage(image);

		new MenuItem(contextMenu, SWT.SEPARATOR);

		MenuItem radioItem1 = new MenuItem(contextMenu, SWT.RADIO);
		radioItem1.setText("Radio item 1");
		radioItem1.setImage(image);
		radioItem1.setSelection(true);

		MenuItem radioItem2 = new MenuItem(contextMenu, SWT.RADIO);
		radioItem2.setText("Radio item 2");
		radioItem2.setImage(image);
		radioItem2.setSelection(true);

		label.setMenu(contextMenu);

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
