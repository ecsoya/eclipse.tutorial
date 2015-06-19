package org.ecsoya.eclipse.tutorial.rcp;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction aboutAction;
	private IWorkbenchAction introAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		aboutAction = ActionFactory.ABOUT.create(window);

		introAction = ActionFactory.INTRO.create(window);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager menu = new MenuManager("Ecsoya");

		menu.add(introAction);
		menu.add(aboutAction);

		menuBar.add(menu);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();

		IProject project = root.getProject();
		IFolder folder = project.getFolder("Ecsoya");
		if (folder.exists()) {
			try {
				folder.delete(true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		System.out.println(projects);
		workspace.addResourceChangeListener(new IResourceChangeListener() {

			public void resourceChanged(IResourceChangeEvent event) {

			}
		});
	}

}
