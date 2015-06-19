---
layout: page
title: Tree Tutorial
wikiPageName: Tree-Tutorial
menu: wiki
---

`Tree`和上一篇讲过的[Table](https://github.com/ecsoya/eclipse.tutorial/wiki/Table-Tutorial)非常类似。是由 `org.eclipse.swt.widgets.Tree`，`org.eclipse.swt.widgets.TreeItem`和`org.eclipse.swt.widgets.TreeColumn`实现的，只不过`TreeItem`还可以添加子节点罢了。

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Tree Tutorial");
		shell.setSize(400, 300);

		GridLayout layout = new GridLayout(2, true);
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 0;
		shell.setLayout(layout);

		new Label(shell, SWT.NONE).setText("Tree with default style");
		new Label(shell, SWT.NONE).setText("Tree with SWT.CHECK style");

		// Tree with default style
		Tree tree1 = new Tree(shell, SWT.BORDER);
		tree1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image taskImage = new Image(display,
				TreeTutorial.class.getResourceAsStream("task.gif"));
		// Add 5 Tree items.
		for (int i = 0; i < 5; i++) {
			TreeItem item = new TreeItem(tree1, SWT.CENTER);
			item.setText("default-item " + i);
			item.setImage(taskImage);

			// Add 5 sub item.
			for (int j = 0; j < 5; j++) {
				TreeItem subItem = new TreeItem(item, SWT.LEFT);
				subItem.setText("sub-item " + i + j);
				subItem.setImage(taskImage);
			}
			if (i == 3) {
				item.setExpanded(true);
			}
		}

		// Add Tree column
		TreeColumn nameColumn = new TreeColumn(tree1, SWT.CENTER);
		nameColumn.setText("Name");
		nameColumn.setImage(taskImage);
		nameColumn.setWidth(160);

		// Make herder visible
		tree1.setHeaderVisible(true);

		// Tree with SWT.CHECK style
		Tree tree2 = new Tree(shell, SWT.CHECK | SWT.BORDER);
		tree2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Image helpImage = new Image(display,
				TreeTutorial.class.getResourceAsStream("help.gif"));

		// Add 5 Tree items.
		for (int i = 0; i < 5; i++) {
			TreeItem item = new TreeItem(tree2, SWT.CENTER);
			item.setText("check-item " + i);
			item.setImage(helpImage);

			// Add 5 sub item.
			for (int j = 0; j < 5; j++) {
				TreeItem subItem = new TreeItem(item, SWT.LEFT);
				subItem.setText("sub-item " + i + j);
				subItem.setImage(helpImage);
				subItem.setChecked(true);
			}
			if (i == 0) {
				item.setExpanded(true);
			}
		}

		// Add Tree column
		TreeColumn optionColumn = new TreeColumn(tree2, SWT.CENTER);
		optionColumn.setText("Option");
		optionColumn.setWidth(160);
		optionColumn.setImage(helpImage);

		// Make herder visible
		tree2.setHeaderVisible(true);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		helpImage.dispose();
		display.dispose();

如图：

**[[images/image_swt_tree.png]]**

***
### Expand 和 Collapse
我们已经提过而且看到`Tree`和`Table`的最大的不同就是`TreeItem`可以有子节点，那么，有了子节点就会涉及到`Expand`和`Collapse`。
通过上面的示例你应该已经看见了，有些节点是展开的。方法其实很简单，就一句：

    item.setExpanded(true);

但是，有个前提，必须是当前的`TreeItem`有子节点的情况下设置才会有效。换言之，就是这个方法的调用，必须放在创建子节点之后，切记。

关于`Expand`和`Collapse`不得不说说`TreeListener`。

		tree.addTreeListener(new TreeListener() {
			
			@Override
			public void treeExpanded(TreeEvent e) {
				//Put your code here.
			}
			
			@Override
			public void treeCollapsed(TreeEvent e) {
				//Put your code here.				
			}
		});

没错，就是展开节点和合上节点之后会触发的事件。

***
想了解更多的关于自定义Tree的相关内容请看[Custom Drawing Table and Tree Items](http://www.eclipse.org/articles/article.php?file=Article-CustomDrawingTableAndTreeItems/index.html)

***
参考资料：
  * [Tree, TreeItem, TreeColumn snippets](http://www.eclipse.org/swt/snippets/#tree)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置](https://github.com/ecsoya/eclipse.tutorial/wiki/Common-Properties-Tutorial)。
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器](https://github.com/ecsoya/eclipse.tutorial/wiki/Layouts-Tutorial)。
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Table Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Table-Tutorial)
下一篇：[ToolBar Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/ToolBar-Tutorial)
