package org.ecsoya.eclipse.tutorial.jface.viewers.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.ecsoya.eclipse.tutorial.jface.viewers.Author;
import org.ecsoya.eclipse.tutorial.jface.viewers.Book;
import org.ecsoya.eclipse.tutorial.jface.viewers.Library;
import org.ecsoya.eclipse.tutorial.jface.viewers.LibraryFactory;
import org.ecsoya.eclipse.tutorial.jface.viewers.Model;

public class TreeViewerTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TreeViewer Tutorial");

		shell.setLayout(new FillLayout());

		TreeViewer viewer = new TreeViewer(shell, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		viewer.setContentProvider(new MyContentProvider());
		viewer.setLabelProvider(new MyLabelProvider());
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

	private static class MyContentProvider implements ITreeContentProvider {
		private Map<Library, Set<Author>> authorMap = new HashMap<Library, Set<Author>>();

		public void dispose() {
			authorMap.clear();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List<?>) {
				return ((List<?>) inputElement).toArray();
			}
			return new Object[0];
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Library) {
				Set<Author> authors = authorMap.get(parentElement);
				if (authors == null) {
					authors = new HashSet<Author>();
					List<Book> books = ((Library) parentElement).getBooks();
					for (Book book : books) {
						Author author = book.getAuthor();
						if (author == null) {
							continue;
						}
						authors.add(author);
					}
					authorMap.put((Library) parentElement, authors);
				}
				return authors.toArray();
			} else if (parentElement instanceof Author) {
				return ((Author) parentElement).getBooks().toArray();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof Book) {
				return ((Book) element).getAuthor();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length != 0;
		}
	}

	private static class MyLabelProvider extends LabelProvider {
		public String getText(Object element) {
			if (element instanceof Model) {
				return element.getClass().getSimpleName() + ": "
						+ ((Model) element).getName();
			}
			return super.getText(element);
		}
	}
}
