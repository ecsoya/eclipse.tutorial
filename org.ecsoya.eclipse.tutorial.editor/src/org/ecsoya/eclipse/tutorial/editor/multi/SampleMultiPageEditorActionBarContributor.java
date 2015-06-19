package org.ecsoya.eclipse.tutorial.editor.multi;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;

public class SampleMultiPageEditorActionBarContributor extends
		MultiPageEditorActionBarContributor {

	public void setActivePage(IEditorPart activeEditor) {

	}

	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
	}

	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);
	}
}
