---
layout: page
title: Sash Tutorial
wikiPageName: Sash-Tutorial
menu: wiki
---

`Sash`是一个可拖动的组件，也有水平的`（SWT.HORIZONTAL）`和垂直的`（SWT.VERTICAL）`两种类型。不过我们经常会用到另外一个基于Sash的组件[SashForm]({{site.baseurl}}/eclipse.tutorial/wiki/SashForm-Tutorial.html)

我们还是先通过一个示例来认识一下它吧：

		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("Sash Tutorial");
		shell.setSize(315, 200);

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		// SWT.HORIZONTAL | SWT.SMOOTH
		Group group1 = new Group(shell, SWT.NONE);
		group1.setText("Horizontal && Smooth");

		Sash hSash = new Sash(group1, SWT.HORIZONTAL | SWT.SMOOTH);
		Rectangle rect = group1.getClientArea();
		hSash.setBounds(rect.x, 40, 315, 10);
		hSash.setBackground(display.getSystemColor(SWT.COLOR_RED));

		// SWT.VERTICAL
		Group group2 = new Group(shell, SWT.NONE);
		group2.setText("Vertical");

		final Sash vSash = new Sash(group2, SWT.VERTICAL);
		Rectangle r = group2.getClientArea();
		vSash.setBounds(150, r.y, 20, 100);
		vSash.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event e) {
				vSash.setBounds(e.x, e.y, e.width, e.height);
			}
		});
		vSash.setBackground(display.getSystemColor(SWT.COLOR_GRAY));

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

我们来看图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_sash.png)

图中所示的红色横条和灰色竖条就是`Sash`，他们是可以拖动的。

### SWT.SMOOTH

`Sash`被设置了`SWT.SMOOTH`属性之后，`Sash`的实际位置会随着`Sash`的拖动而自动更新。反之，`Sash`不会被真正的拖动，只会出现一个预览，`Sash`的位置需要自行去修改，请看上面示例中的垂直的`Sash`。

***
参考资料：
  * [Sash snippets](http://www.eclipse.org/swt/snippets/#sash)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Menu Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Menu-Tutorial.html)
下一篇：[ToolTip Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/ToolTip-Tutorial.html)
