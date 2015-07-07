---
layout: page
title: CoolBar Tutorial
wikiPageName: CoolBar-Tutorial
menu: wiki
---

`CoolBar`和[ToolBar]({{site.baseurl}}/eclipse.tutorial/wiki/ToolBar-Tutorial.html)有点类似，一般都是用在创建工具栏上，不过，`CoolBar`的功能更加丰富，`CoolItem`可以在`CoolBar`上面自由的拖拽，隐藏等等。它是由`org.eclipse.swt.widgets.CoolBar`和`org.eclipse.swt.widgets.CoolItem`实现的

我们先看一个简单的示例吧：

		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("CoolBar Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout());

		final Image taskImage = new Image(display,
				CoolBarTutorial.class.getResourceAsStream("task.gif"));

		final CoolBar coolBar = new CoolBar(shell, SWT.HORIZONTAL | SWT.FLAT);

		for (int i = 0; i < 5; i++) {
			CoolItem item = new CoolItem(coolBar, SWT.NONE);
			Button control = new Button(coolBar, SWT.NONE);
			control.setImage(taskImage);
			control.setText("Button - " + i);
			item.setControl(control);
			Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			item.setPreferredSize(item.computeSize(size.x, size.y));
		}
		coolBar.setWrapIndices(new int[] { 1, 3 });
		coolBar.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_coolbar1.png)

### 要点

_**CoolBar**_

1. **Orientation**：`CoolBar也分为水平的（SWT.HORIZONTAL）和垂直（SWT.VERTICAL）的两种。`
2. **SWT.FLAT**：`没有设置的话，CoolBar会有带系统默认的背景色，否则没有。`
3. **setLock()**：`设置CoolItem是否锁定，默认为不锁定，如上述示例中的CoolItem就可以拖拽移动；一旦锁定，就不能移动。`
4. **setWrapIndices()**：`设置要换行的CoolItem的索引值，默认会将所有的CoolItem显示在同一行。如上述示例中设置了new int[] { 1, 3 }，就是说遇到第1个和第3个CoolItem的时候换行显示。`

_**CoolItem**_

1. **Size**：`CoolItem的大小一定要自己设置，其中有三个概念，setMinimumSize(),setPreferredSize()和setSize()，并且这些值的默认都是0。最小值是在缩放CoolItem的时候会用到，size如果没有设置，就取PreferredSize，如果都没有设置，则CoolItem就不会显示。`
2. **SWT.DROP_DOWN**：`下拉菜单。`
3. **SelectionListener**：`选择下拉菜单按钮时触发。`

关于2和3，请看示例：[drop-down a chevron menu containing hidden tool items](http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet140.java)

***
参考资料：
  * [CoolBar snippets](http://www.eclipse.org/swt/snippets/#coolbar)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[ToolBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/ToolBar-Tutorial.html)
下一篇：[ProgressBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/ProgressBar-Tutorial.html)
