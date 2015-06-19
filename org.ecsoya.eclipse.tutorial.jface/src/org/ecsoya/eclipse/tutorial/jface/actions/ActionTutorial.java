package org.ecsoya.eclipse.tutorial.jface.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class ActionTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Action Tutorial");

		MenuManager manager = new MenuManager();
		manager.add(new Action("Push", IAction.AS_PUSH_BUTTON) {
		});
		manager.add(new Separator());
		manager.add(new Action("CheckBox1", IAction.AS_CHECK_BOX) {
		});
		manager.add(new Action("CheckBox2", IAction.AS_CHECK_BOX) {
		});

		Menu menu = manager.createContextMenu(shell);
		shell.setMenu(menu);

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
