---
layout: page
title: List Tutorial
wikiPageName: List-Tutorial
menu: wiki
---

`List`和上一篇讲过的`列表式（SWT.SIMPLE）Combo`类似，都是用来从一堆选项中选择可用项的。不过`List`分为`单选的（SWT.SINGLE）`和`可多选的(SWT.MULTI)`两类。

闲话少说，引例为证：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("List Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		List list1 = new List(shell, SWT.SINGLE | SWT.BORDER);
		for (int i = 0; i < 5; i++) {
			list1.add("single-selection-" + i);
		}
		list1.select(2);

		List list2 = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		list2.setLayoutData(new RowData(SWT.DEFAULT, 60));
		for (int i = 0; i < 5; i++) {
			list2.add("multi-selection-" + i);
		}
		list2.select(2, 3);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_list1.png)

***

### 需要注意的地方

 * `默认情况下，List不显示边框，需要用SWT.BORDER来设置。`
 * `默认情况下，List不显示滚动条，需要用SWT.V_SCROLL和SWT.H_SCROLL来设置。`

***

### 事件监听

**1.** _**DefaultSelection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.DefaultSelection, Listener)来添加。`

_触发条件_：`当List中的某一项被双击时，立即触发`。

**2.** _**Selection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.Selection, Listener)来添加。`

_触发条件_：`当List中的选择项发生变化时，立即触发`。

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("List Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Text text = new Text(shell, SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final List list = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		list.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		for (int i = 0; i < 5; i++) {
			list.add("multi-selection-" + i);
		}
		list.select(2, 3);
		list.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selection = list.getSelection();
				text.setText("Selected items: " + Arrays.toString(selection));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selection = list.getSelection();
				text.setText(text.getText() + "\nDouble clicked on: "
						+ Arrays.toString(selection));
			}
		});

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

***
参考资料：
  * [List snippets](http://www.eclipse.org/swt/snippets/#list)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[Combo Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Combo-Tutorial.html)
下一篇：[Scale Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Scale-Tutorial.html)
