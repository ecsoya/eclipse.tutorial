---
layout: page
title: TabFolder Tutorial
wikiPageName: TabFolder-Tutorial
menu: wiki
---

`TabFolder`是一个支持多页签的容器，每一个页签都是一个`TabItem`，而每一个`TabItem`都可以设置一个`Control`来添加具体的内容。

看一个示例：

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabFolder Tutorial");
		shell.setLayout(new FillLayout());

		TabFolder folder = new TabFolder(shell, SWT.TOP);
		for (int i = 0; i < 3; i++) {
			TabItem item = new TabItem(folder, SWT.NONE);
			item.setText("item " + i);

			Label label = new Label(folder, SWT.NONE);
			label.setText("Add control here.");
			item.setControl(label);
		}
		folder.setSelection(1);

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_tabfolder.png)

### 另外：

1. `页签（TabItem）也可以通过 SWT.BOTTOM 设置，显示在底部。`
2. `每一个 TabItem 也可以设置图标。`

***
参考资料：
  * [TabFolder, TabItem snippets](http://www.eclipse.org/swt/snippets/#tabfolder)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Group Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Group-Tutorial.html)
下一篇：[Shell Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Shell-Tutorial.html)
