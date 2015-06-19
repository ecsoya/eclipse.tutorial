package org.ecsoya.eclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class VirtualTableViewerTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Virtual TableViewer Tutorial");
		shell.setLayout(new FillLayout());

		TableViewer viewer = new TableViewer(shell, SWT.VIRTUAL);
		viewer.setContentProvider(new LazyContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		String[] inputs = new String[100000];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = "Value " + i;
		}
		viewer.setItemCount(inputs.length);
		viewer.setUseHashlookup(true);
		viewer.setInput(inputs);

		shell.setSize(400, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static class LazyContentProvider implements ILazyContentProvider {
		private TableViewer viewer;
		private String[] elements;

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			this.viewer = (TableViewer) viewer;
			elements = (String[]) newInput;
		}

		public void updateElement(int index) {
			viewer.replace(elements[index], index);
		}
	}

}
