package org.ecsoya.eclipse.tutorial.editor.sample;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.ecsoya.eclipse.tutorial.editor.Activator;

public class OpenEditorHelper {

	public void openEditor() {
		// Workbench instance from our plugin instance.
		IWorkbench workbench = Activator.getDefault().getWorkbench();
		// Active window instance.
		IWorkbenchWindow activeWorkbenchWindow = workbench
				.getActiveWorkbenchWindow();
		// Active page instance.
		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		try {
			SampleEditorInput editorInput = new SampleEditorInput();
			// Open editor from the editor input and editor ID.
			activePage.openEditor(editorInput, SampleEditor.ID); // defined from
																	// extension.
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
