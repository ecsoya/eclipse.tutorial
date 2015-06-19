package org.ecsoya.eclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.ecsoya.eclipse.tutorial.jface.viewers.Book;
import org.ecsoya.eclipse.tutorial.jface.viewers.Library;
import org.ecsoya.eclipse.tutorial.jface.viewers.LibraryFactory;

public class TableEditorTutorial {

	public static void main(String[] args) {

		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TableViewer Tutorial");
		shell.setLayout(new FillLayout());

		Library library = LibraryFactory.createLibrary1();

		final TableViewer viewer = new TableViewer(shell, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		viewer.setContentProvider(new MyContentProvicer1());

		viewer.getTable().setHeaderVisible(true);

		TableViewerColumn nameColumn = new TableViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setWidth(200);
		nameColumn.setLabelProvider(new CellLabelProvider() {

			public void update(ViewerCell cell) {
				TableItem item = (TableItem) cell.getItem();
				if (item.getData("EDITOR") != null) {
					TableEditor editor = (TableEditor) item.getData("EDITOR");
					editor.getEditor().dispose();
					editor.dispose();
				}
				TableEditor editor = new TableEditor(item.getParent());
				Composite control = new Composite(item.getParent(), SWT.NONE);
				control.setBackground(item.getParent().getBackground());
				control.setBackgroundMode(SWT.INHERIT_DEFAULT);
				RowLayout layout = new RowLayout(SWT.HORIZONTAL);
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.marginBottom = 0;
				layout.marginLeft = 0;
				layout.marginRight = 0;
				layout.marginTop = 0;
				control.setLayout(layout);
				Button button = new Button(control, SWT.RADIO);
				button.setText(((Book) cell.getElement()).getName());
				editor.grabHorizontal = true;
				editor.setEditor(control, item, 0);

				item.setData("EDITOR", editor);
			}
		});
		viewer.setInput(library);

		shell.setSize(400, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static class MyContentProvicer1 implements
			IStructuredContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Library) {
				return ((Library) inputElement).getBooks().toArray();
			}
			return new Object[0];
		}
	}
}
