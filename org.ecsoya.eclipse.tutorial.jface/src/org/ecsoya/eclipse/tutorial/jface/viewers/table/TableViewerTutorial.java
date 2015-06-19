package org.ecsoya.eclipse.tutorial.jface.viewers.table;

import java.text.Collator;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.ecsoya.eclipse.tutorial.jface.viewers.Author;
import org.ecsoya.eclipse.tutorial.jface.viewers.Book;
import org.ecsoya.eclipse.tutorial.jface.viewers.Library;
import org.ecsoya.eclipse.tutorial.jface.viewers.LibraryFactory;
import org.ecsoya.eclipse.tutorial.jface.viewers.Model;

public class TableViewerTutorial {

	private static final String[] COLUMN_PROPERYIES = { "NAME", "AUTHOR" };

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
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof Book) {
					return ((Book) element).getName();
				}
				return super.getText(element);
			}

			public Color getForeground(Object element) {
				return display.getSystemColor(SWT.COLOR_BLUE);
			}
		});

		TableViewerColumn authorColumn = new TableViewerColumn(viewer, SWT.NONE);
		authorColumn.getColumn().setText("Author");
		authorColumn.getColumn().setWidth(100);
		authorColumn.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof Book) {
					Author author = ((Book) element).getAuthor();
					if (author != null) {
						return author.getName() + "(" + author.getAge() + ")";
					}
				}
				return super.getText(element);
			}

			public Color getBackground(Object element) {
				return display.getSystemColor(SWT.COLOR_CYAN);
			}
		});
		authorColumn.setEditingSupport(new EditingSupport(viewer) {

			protected void setValue(Object element, Object value) {
				if (element instanceof Book) {
					Author author = ((Book) element).getAuthor();
					if (author != null) {
						author.setName(value.toString());
					}
				}
				viewer.update(element, null);
			}

			protected Object getValue(Object element) {
				if (element instanceof Book) {
					Author author = ((Book) element).getAuthor();
					return author.getName();
				}
				return null;
			}

			protected CellEditor getCellEditor(Object element) {
				return new DialogCellEditor(viewer.getTable()) {

					protected Object openDialogBox(Control cellEditorWindow) {
						InputDialog dialog = new InputDialog(cellEditorWindow
								.getShell(), "Author Name",
								"Change the name of Author",
								(String) getValue(), null);
						dialog.open();
						return dialog.getValue();
					}
				};
			}

			protected boolean canEdit(Object element) {
				return true;
			}
		});

		// Cell Editors
		//
		// viewer.setColumnProperties(COLUMN_PROPERYIES);
		// viewer.setCellEditors(new CellEditor[] {
		// new TextCellEditor(viewer.getTable()), null });
		// viewer.setCellModifier(new ICellModifier() {
		//
		// public void modify(Object element, String property, Object value) {
		// if (COLUMN_PROPERYIES[0].equals(property)) {
		// if (element instanceof TableItem) {
		// element = ((TableItem) element).getData();
		// }
		// if (element instanceof Book) {
		// ((Book) element).setName(value.toString());
		// }
		// }
		// viewer.update(element, new String[] { property });
		// }
		//
		// public Object getValue(Object element, String property) {
		// if (COLUMN_PROPERYIES[0].equals(property)) {
		// if (element instanceof Book) {
		// return ((Book) element).getName();
		// }
		// }
		// return null;
		// }
		//
		// public boolean canModify(Object element, String property) {
		// return COLUMN_PROPERYIES[0].equals(property);
		// }
		// });

		// viewer.setLabelProvider(new MyLabelProvider2());
		// viewer.setLabelProvider(new MyLabelProvider1());

		// viewer.addFilter(new ViewerFilter() {
		//
		// public boolean select(Viewer viewer, Object parentElement,
		// Object element) {
		// if (element instanceof Book) {
		// Author author = ((Book) element).getAuthor();
		// if (author != null && author.getAge() < 40) {
		// return false;
		// }
		// }
		// return true;
		// }
		// });

		viewer.setInput(library);
		viewer.getTable().setSortColumn(nameColumn.getColumn());
		nameColumn.getColumn().addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				viewer.setComparator(new ViewerComparator() {
					public int compare(Viewer viewer, Object e1, Object e2) {
						String n1 = ((Book) e1).getName();
						String n2 = ((Book) e2).getName();
						int value = Collator.getInstance().compare(n1, n2);
						int sort = ((TableViewer) viewer).getTable()
								.getSortDirection();
						if ((sort & SWT.DOWN) != 0) {
							return -value;
						} else if ((sort & SWT.UP) != 0) {
							return value;
						}
						return 0;
					}
				});
				int sort = viewer.getTable().getSortDirection();
				viewer.getTable().setSortDirection(
						(SWT.UP & sort) != 0 ? SWT.DOWN : SWT.UP);
			}
		});

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

	private static class MyLabelProvider1 extends LabelProvider {
		public String getText(Object element) {
			if (element instanceof Model) {
				return ((Model) element).getName();
			}
			return super.getText(element);
		}
	}

	private static class MyLabelProvider2 extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Book) {
				if (columnIndex == 0) {
					return ((Book) element).getName();
				} else if (columnIndex == 1) {
					Author author = ((Book) element).getAuthor();
					if (author != null) {
						return author.getName();
					}
				}
			}
			return null;
		}
	}
}
