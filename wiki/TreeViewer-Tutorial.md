---
layout: page
title: TreeViewer Tutorial
wikiPageName: TreeViewer-Tutorial
menu: wiki
---

TreeViewer和[TableViewer](http://ecsoya.github.io/eclipse.tutorial/wiki/TableViewer-Tutorial)的用法基本相似，最大的不同就是TreeViewer有子节点，所以这个也体现在*content provider*的不同上。

如：

	class BookTreeContentProvider implements ITreeContentProvider {
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

其中：

1. `getElement()`方法取的是根目录元素。
2. `getChildren()`方法取的是每一个元素的子节点，包含根目录元素。
3. `hasChildren()`方法是在`getChildren()`方法调用之前判断有没有子节点的。
4. `getParent()`方法对应取到的是子节点的父节点元素。

### 参考资料：

1. [JFace snippets and examples](http://ecsoya.github.io/eclipse.tutorial/wiki/Build-JFace-Snippets)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[TableViewer Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/TableViewer-Tutorial) 下一篇：[JFace Dialog Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-Dialogs-Tutorial)
