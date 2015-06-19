package org.ecsoya.eclipse.tutorial.editor.sample;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class SampleEditor extends EditorPart {

	public static final String ID = "org.ecsoya.eclipse.tutorial.editor.sample";

	private Composite control;

	public SampleEditor() {
	}

	public void doSave(IProgressMonitor monitor) {
		// Save data of editor.
		firePropertyChange(PROP_DIRTY);
	}

	public boolean isDirty() {
		// return true if need to save.
		return false;
	}

	public void doSaveAs() {
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);

		setPartName("Ecsoya - Sample editor");
		setTitleToolTip("Welcome to soyatec!");
		firePropertyChange(IWorkbenchPart.PROP_TITLE);
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void createPartControl(Composite parent) {
		control = new Composite(parent, SWT.NONE);
		// create editor control here
	}

	public void setFocus() {
		control.setFocus();
	}

	public Object getAdapter(Class adapter) {
		if (IContentOutlinePage.class == adapter) {
			return new SampleContentOutlinePage();
		}
		return super.getAdapter(adapter);
	}
}
