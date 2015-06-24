---
layout: page
title: Combo Tutorial
wikiPageName: Combo-Tutorial
menu: wiki
---

一般情况下，`Combo`是一个只能从给定的多个选项中选择一个的单项选择框。`Combo`有两种风格一种是下拉式的（`SWT.DROP_DOWN`），一种是列表式的（`SWT.SIMPLE`）。下拉式的（`SWT.DROP_DOWN`）`Combo`如果不是只读（`SWT.READ_ONLY`）的，它会继承[Text]({{site.baseurl}}/eclipse.tutorial/wiki/Text-Tutorial.html)的所有属性

还是先通过一段示例来看看吧：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Combo Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));
		
		Combo dropDown = new Combo(shell, SWT.DROP_DOWN);
		for (int i = 0; i < 5; i++) {
			dropDown.add("drop-down -" + i);
		}
		dropDown.select(2);
		
		Combo simple = new Combo(shell, SWT.SIMPLE);
		for (int i = 0; i < 5; i++) {
			simple.add("simpe-item-" + i);
		}
		simple.select(3);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

运行之后如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_combo1.png)

***
### 需要注意的问题

 * `只读（SWT.READ_ONLY）属性只对下拉式（SWT.DROP_DOWN）Combo有用，而列表式（SWT.SIMPLE）Combo不能设置为只读。`
 * `若非只读，Combo的可编辑的Text会支持Text控件的所有的属性，包括事件监听和处理。`
 * `Combo的选项只支持非空的字符串，操作方法有：add(String), remove(index), remove(start, end)，getItems()，getItem(index)等。`
 * `Combo的选择项的设置和读取都是通过选项的索引值（index）来完成的，比如：select(index)和getSelectionIndex()。`

***
### 事件监听

**1.** _**DefaultSelection**_：`请看`[Text 事件监听]({{site.baseurl}}/eclipse.tutorial/wiki/Text-Tutorial.html)

**2.** _**Modify**_：`请看`[Text 事件监听]({{site.baseurl}}/eclipse.tutorial/wiki/Text-Tutorial.html)

**3.** _**Verify**_：`请看`[Text 事件监听]({{site.baseurl}}/eclipse.tutorial/wiki/Text-Tutorial.html)

**4.** _**Selection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.Selection, Listener)添加。`

_触发条件:_

  * 当Combo中的选择项更改时立即触发。

    	Combo dropDown = new Combo(shell, SWT.DROP_DOWN);
		dropDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Put your code here
			}
		});

***
参考资料：
  * [Combo snippets](http://www.eclipse.org/swt/snippets/#combo)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Text Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Text-Tutorial.html)
下一篇：[List Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/List-Tutorial.html)
