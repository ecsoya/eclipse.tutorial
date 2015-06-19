package org.ecsoya.eclipse.tutorial.jface.viewers.tree;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.ecsoya.eclipse.tutorial.jface.viewers.Book;
import org.ecsoya.eclipse.tutorial.jface.viewers.Library;
import org.ecsoya.eclipse.tutorial.jface.viewers.LibraryFactory;
import org.ecsoya.eclipse.tutorial.jface.viewers.Model;

public class TreePathTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TreeViewer Tutorial");

		shell.setLayout(new FillLayout());

		TreeViewer viewer = new TreeViewer(shell, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		viewer.setContentProvider(new MyTreePathContentProvider());
		viewer.setLabelProvider(new MyTreePathLabelProvider());
		viewer.setInput(LibraryFactory.getLibraries());

		shell.setSize(400, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static class MyTreePathContentProvider implements
			ITreePathContentProvider {

		@Override
		public void dispose() {

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection<?>) {
				return ((Collection<?>) inputElement).toArray();
			}
			return new Object[0];
		}

		@Override
		public Object[] getChildren(TreePath parentPath) {
			Object element = parentPath.getLastSegment();
			if (element instanceof Library) {
				return ((Library) element).getBooks().toArray();
			} else if (element instanceof Book) {
				return new Object[] { ((Book) element).getAuthor() };
			}
			return new Object[0];
		}

		@Override
		public boolean hasChildren(TreePath path) {
			Object element = path.getLastSegment();
			if (element instanceof Library) {
				return !((Library) element).getBooks().isEmpty();
			} else if (element instanceof Book) {
				return ((Book) element).getAuthor() != null;
			}
			return false;
		}

		@Override
		public TreePath[] getParents(Object element) {
			return new TreePath[0];
		}

	}

	private static class MyTreePathLabelProvider extends LabelProvider
			implements ITreePathLabelProvider {

		@Override
		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			Object element = elementPath.getLastSegment();
			if (element instanceof Model) {
				label.setText(((Model) element).getName());
			}
		}

	}
}
