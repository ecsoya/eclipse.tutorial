---
layout: page
title: Group Tutorial
wikiPageName: Group-Tutorial
menu: wiki
---

Group除了可以设置标题外，其它的属性和[Composite]({{site.baseurl}}/eclipse.tutorial/wiki/Composite-Tutorial.html)一样

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Group Tutorial");
		shell.setLayout(new RowLayout());

		Group group = new Group(shell, SWT.NONE);
		group.setText("Foxes vs. Dogs");

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_group.png)

***
参考资料：
  * [Sample code and further information](http://www.eclipse.org/swt/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[Canvas Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Canvas-Tutorial.html)
下一篇：[TabFolder Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/TabFolder-Tutorial.html)