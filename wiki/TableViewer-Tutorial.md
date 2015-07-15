---
layout: page
title: TableViewer Tutorial
wikiPageName: TableViewer-Tutorial
menu: wiki
---

TableViewer是一个比较常用的Viewer，它是对[SWT Table](http://ecsoya.github.io/eclipse.tutorial/wiki/Table-Tutorial)的一个封装。

### 模型

	Library library = new Library("Center Public Library");

	library.addBook(new Book("Children Education, 3-6 years old",
			new Author("Ben Jermain", 34)));
	library.addBook(new Book("Children Education, 6-12 years old",
			new Author("Ben Jermain", 34)));

	library.addBook(new Book("Baby Names Book", new Author("Quan Jia", 56)));
	library.addBook(new Book("Java Development", new Author("Van Jondon",
			43)));
>
> **需求**：*将Library中所有的Book显示在Table中，Table有两列，第一列显示Book名称，第二列显示Author名称。*
>

### 1. 常规用法

#### 创建TableViewer

	final TableViewer viewer = new TableViewer(shell, SWT.MULTI
			| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);

	Table table = viewer.getTable();
	// make lines and columns visible
	table.setLinesVisible(true);
	table.setHeaderVisible(true);

#### 创建TableViewerColumn

	TableViewerColumn nameColumn = new TableViewerColumn(viewer, SWT.NONE);
	nameColumn.getColumn().setText("Name");
	nameColumn.getColumn().setWidth(200);
	
	TableViewerColumn authorColumn = new TableViewerColumn(viewer, SWT.NONE);
	authorColumn.getColumn().setText("Author");
	authorColumn.getColumn().setWidth(100);
		
#### 设置Content Provider

	viewer.setContentProvider(new BookContentProvider());

Class BookContentProvider

	class BookContentProvider implements
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

#### 设置Label Provider

	 viewer.setLabelProvider(new BookLabelProvider());

Class BookLabelProvider

	class BookLabelProvider extends LabelProvider implements
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
 
#### 设置input

	viewer.setInput(library);

运行之后如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_tableviewer3.png)

### 2. 高级用法

#### 通过CellLabelProvider来设置Label Provider

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

#### 设置CellEditor方法一

	private static final String[] COLUMN_PROPERYIES = { "NAME", "AUTHOR" };

	viewer.setColumnProperties(COLUMN_PROPERYIES);
	viewer.setCellEditors(new CellEditor[] {
			new TextCellEditor(viewer.getTable()), null });
	viewer.setCellModifier(new ICellModifier() {
		public void modify(Object element, String property, Object value) {
			if (COLUMN_PROPERYIES[0].equals(property)) {
				if (element instanceof TableItem) {
					element = ((TableItem) element).getData();
				}
				if (element instanceof Book) {
					((Book) element).setName(value.toString());
				}
			}
			viewer.update(element, new String[] { property });
		}

		public Object getValue(Object element, String property) {
			if (COLUMN_PROPERYIES[0].equals(property)) {
				if (element instanceof Book) {
					return ((Book) element).getName();
				}
			}
			return null;
		}

		public boolean canModify(Object element, String property) {
			return COLUMN_PROPERYIES[0].equals(property);
		}
	});

#### 设置CellEditor方法二

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

> 通过给每一个TableViewerColumn来设置CellLabelProvider完成对这一列所有内容的定制。
> 
> 除了常用的ColumnLableProvider，还有OwnerDrawLabelProvider用来自定义绘制表格。

#### 设置过滤器（Filter）

	viewer.addFilter(new ViewerFilter() {

		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof Book) {
				Author author = ((Book) element).getAuthor();
				if (author != null && author.getAge() < 40) {
					return false;
				}
			}
			return true;
		}
	});

> ViewerFilter.select()方法返回true，则显示，否则被过滤掉不显示。

#### 设置排序器（Sorter）

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

> 排序功能主要通过Viewer.setComparator()方法来实现。

### 参考资料：

1. [JFace snippets and examples]()

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)