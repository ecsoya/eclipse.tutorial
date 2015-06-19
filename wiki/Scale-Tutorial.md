---
layout: page
title: Scale Tutorial
wikiPageName: Scale-Tutorial
menu: wiki
---

刻度条（Scale）比较简单，分为水平的（SWT.HORIZONTAL）和垂直的（SWT.VERTICAL）两种。

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Scale Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		Scale vScale = new Scale(shell, SWT.VERTICAL);

		Scale hScale = new Scale(shell, SWT.HORIZONTAL);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

**[[images/image_swt_scale1.png]]**

***

### 需要注意的问题

 * _**Minimum Value**_：`设置最小刻度值，最小是0。`
 * _**Maximum Value**_：`设置最大刻度值，必须比最小值刻度值大。`
 * _**Page Increment**_：`设置刻度一格的大小，最小值是1。`
 * _**Increment**_：`设置用键盘上下或左右方向键滚动时的值，最小为1。通常情况下，上下方向键对垂直的刻度条有效，左右方向键对水平的刻度条有用。`
 * _**Selection**_：`设置当前滚动条的位置，最小为0。`

***

### 事件监听

**1.** _**Selection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.Selection, Listener)添加。`

    	Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Scale Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Label label = new Label(shell, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Scale scale = new Scale(shell, SWT.HORIZONTAL);
		scale.setMaximum(100);
		scale.setPageIncrement(10);
		scale.setIncrement(5);
		scale.setSelection(20);
		scale.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				label.setText("Selection: " + scale.getSelection());
			}
		});
		scale.setFocus();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

***
参考资料：
  * [Scale snippets](http://www.eclipse.org/swt/snippets/#scale)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置](https://github.com/ecsoya/eclipse.tutorial/wiki/Common-Properties-Tutorial)。
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器](https://github.com/ecsoya/eclipse.tutorial/wiki/Layouts-Tutorial)。
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Combo Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Combo-Tutorial)
下一篇：[Slider Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Slider-Tutorial)

