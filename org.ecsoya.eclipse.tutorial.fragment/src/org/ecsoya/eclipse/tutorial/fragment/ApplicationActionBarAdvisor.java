package org.ecsoya.eclipse.tutorial.fragment;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	private IAction testAction;

	protected void makeActions(final IWorkbenchWindow window) {
		testAction = new Action("Message Dialog") {
			public void run() {
				MessageDialog
						.openConfirm(window.getShell(),
								"Eclipse Fragment Tutorial",
								"Display Chinese Labels for OK and Cancel buttons, do you see them?");
			}
		};
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		IMenuManager menu = new MenuManager("Ecsoya");
		menu.add(testAction);
		menuBar.add(menu);
	}

}
