package org.ecsoya.eclipse.tutorial.editor.sample;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class SampleContentOutlinePage extends ContentOutlinePage {
	private Label control;

	public void createControl(Composite parent) {
		control = new Label(parent, SWT.NONE);
		control.setBackground(parent.getDisplay().getSystemColor(
				SWT.COLOR_GREEN));
		control.setText("Outline for sample editor");
		ISelectionProvider selectionProvider = new ISelectionProvider() {

			@Override
			public void setSelection(ISelection selection) {

			}

			@Override
			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {

			}

			@Override
			public ISelection getSelection() {
				return null;
			}

			@Override
			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {

			}
		};

		String id = "org.ecsoya.eclipse.tutorials.editor.OutlineMenu";
		MenuManager manager = new MenuManager(id);
		manager.add(new Action("Ecsoya") {
		});
		manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		Menu menu = manager.createContextMenu(control);
		control.setMenu(menu);

		getSite().registerContextMenu(id, manager, selectionProvider);
	}

	public Control getControl() {
		return control;
	}

	public void setFocus() {
		control.setFocus();
	}
}
