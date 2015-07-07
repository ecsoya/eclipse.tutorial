---
layout: page
title: ProgressBar Tutorial
wikiPageName: ProgressBar-Tutorial
menu: wiki
---

进度条（`ProgressBar`）除了可以是水平的（`SWT.HORIZONTAL`）也可以是垂直的（`SWT.VERTICAL`）之外，有两种分格，一种是`SWT.SMOOTH`，还有一种是`SWT.INDETERMINATE`，默认情况是`SWT.SMOOTH`。

* **SWT.SMOOTH**：`进度条可以设置最大值，最小值以及当前的进度（Selection），只有进度值发生变化时，进度条才会更新。`
* **SWT.INDETERMINATE**：`进度条会一直滚动显示，最大值，最小值和进度值都对它无效。`

先看一段示例：

		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ProgressBar Tutorial");
		shell.setSize(315, 200);

		shell.setLayout(new GridLayout(2, false));

		// SWT.DEFAULT | SWT.SMOOTH
		final ProgressBar smoothBar = new ProgressBar(shell, SWT.SMOOTH);
		smoothBar.setMaximum(100);
		smoothBar.setSelection(30);

		new Label(shell, SWT.NONE).setText("SWT.SMOOTH");

		// SWT.INDETERMINATE
		new ProgressBar(shell, SWT.INDETERMINATE);
		new Label(shell, SWT.NONE).setText("SWT.INDETERMINATE");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_progressbar.png)

### State

`ProgressBar`在有些系统中（如Windows 7和Mac OS）支持三种类型的状态：`SWT.NORMAL`，`SWT.ERROR`和`SWT.PAUSED`。一般情况下会在[TaskBar]({{site.baseurl}}/eclipse.tutorial/wiki/TaskBar-Tutorial.html)上面以不同的颜色同步显示进度

***
参考资料：
  * [ProgressBar snippets](http://www.eclipse.org/swt/snippets/#progressbar)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[CoolBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/CoolBar-Tutorial.html)
下一篇：[ScrollBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/ScrollBar-Tutorial.html)
