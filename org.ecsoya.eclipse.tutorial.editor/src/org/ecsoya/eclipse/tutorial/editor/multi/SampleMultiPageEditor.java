package org.ecsoya.eclipse.tutorial.editor.multi;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.part.MultiPageEditorPart;

public class SampleMultiPageEditor extends MultiPageEditorPart {

	protected void createPages() {
		// add other controls or editors here.
	}

	public void doSave(IProgressMonitor monitor) {
	}

	public void doSaveAs() {
	}

	public boolean isSaveAsAllowed() {
		return false;
	}
}
