---
layout: page
title: ExpandBar Tutorial
wikiPageName: ExpandBar-Tutorial
menu: wiki
---

`ExpandBar`是一个可展开和收缩的组件，以前的`Windos XP`系统中文件管理器的左侧栏中就用这种组件。SWT中是通过`org.eclipse.swt.widgets.ExpandBar`和`ExpandItem`来实现的。

先看一段示例：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("ExpandBar Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		final Image taskImage = new Image(display,
				ExpandBarTutorial.class.getResourceAsStream("task.gif"));

		ExpandBar expandBar = new ExpandBar(shell, SWT.NONE);

		ExpandItem item1 = new ExpandItem(expandBar, SWT.NONE);
		item1.setText("Expanded item");
		Composite control = new Composite(expandBar, SWT.NONE);
		control.setLayout(new RowLayout(SWT.VERTICAL));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_INFORMATION));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_ERROR));
		item1.setControl(control);
		item1.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item1.setExpanded(true);
		item1.setImage(taskImage);

		ExpandItem item2 = new ExpandItem(expandBar, SWT.NONE);
		item2.setText("Collapsed item");
		control = new Composite(expandBar, SWT.NONE);
		control.setLayout(new RowLayout(SWT.VERTICAL));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_WORKING));
		new Label(control, SWT.NONE).setImage(display
				.getSystemImage(SWT.ICON_QUESTION));
		item2.setControl(control);
		item2.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item2.setImage(taskImage);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_expandbar.png)

### 要点

_**ExpandItem**_

1. `setText()：设置Item上面显示的文字。`
2. `setImage()：设置Item上面显示的图片。`
3. `setExpand()：设置Item的展开状态，默认为收起来的。`
4. `setHeight()：设置Item的内容展开后的高度，默认为0，此项一定要设置，否则即便展开，也看不见里面的内容。`

_**ExpandBar**_

1. `SWT.V_SCROLL：允许加一个垂直的滚动条。`
2. `setSpacing()：设置每一个Item之间的距离。`
3. `ExpandListener：添加事件，当ExpandItem展开或是收起的时候触发。`

***
参考资料：
  * [ExpandBar snippets](http://www.eclipse.org/swt/snippets/#expandbar)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[TaskBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/TaskBar-Tutorial.html)
下一篇：[Menu Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Menu-Tutorial.html)
