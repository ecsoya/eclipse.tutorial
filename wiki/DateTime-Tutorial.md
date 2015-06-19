---
layout: page
title: DateTime Tutorial
wikiPageName: DateTime-Tutorial
menu: wiki
---

`DateTime`是用来显示与时间相关的如年月日，时分秒的组件。它相对比较简单，我们通过一个示例来完整的学习它：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("DateTime Tutorial");

		shell.setLayout(new GridLayout(2, false));

		new Label(shell, SWT.NONE).setText("Date: ");
		new DateTime(shell, SWT.DATE);
		new Label(shell, SWT.NONE).setText("Date(Long): ");
		new DateTime(shell, SWT.DATE | SWT.LONG);
		new Label(shell, SWT.NONE).setText("Date(Medium): ");
		new DateTime(shell, SWT.DATE | SWT.MEDIUM);
		new Label(shell, SWT.NONE).setText("Date(Short): ");
		new DateTime(shell, SWT.DATE | SWT.SHORT);

		new Label(shell, SWT.NONE).setText("Date(Drop Down): ");
		new DateTime(shell, SWT.DATE | SWT.DROP_DOWN);

		new Label(shell, SWT.NONE).setText("Time: ");
		new DateTime(shell, SWT.TIME);
		new Label(shell, SWT.NONE).setText("Time(Short): ");
		new DateTime(shell, SWT.TIME | SWT.SHORT);

		new Label(shell, SWT.NONE).setText("Calendar: ");
		new DateTime(shell, SWT.CALENDAR);

		shell.open();
		shell.pack();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

效果如图：

![]({{site.baseurl}}/wiki/images/image_swt_datetime.png)

***

### 事件监听

**1.** _**DefaultSelection**_：`按下回车键（Enter）时触发。`

**2.** _**Selection**_：`Date或Time发生改变时触发。`

***
参考资料：
  * [DateTime snippets](http://www.eclipse.org/swt/snippets/#datetime)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Spinner Tutorial]({{site.baseurl}}/wiki/Spinner-Tutorial.html)
下一篇：[Table Tutorial]({{site.baseurl}}/wiki/Table-Tutorial.html)
