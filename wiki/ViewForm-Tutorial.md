---
layout: page
title: ViewForm Tutorial
wikiPageName: ViewForm-Tutorial
menu: wiki
---

ViewForm是一个具有特殊的Layout的容器，它将内容分成四个部分，分别是：TopLeft，TopCenter，TopRight和Content。

### 示例

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("ViewForm Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		ViewForm form = new ViewForm(shell, SWT.FLAT);
		Label content = new Label(form, SWT.BORDER);
		content.setText("Content of ViewForm");
		content.setAlignment(SWT.CENTER);
		form.setContent(content);

		Label topLeft = new Label(form, SWT.BORDER);
		topLeft.setText("TopLeft");
		form.setTopLeft(topLeft);

		Label topCenter = new Label(form, SWT.BORDER);
		topCenter.setText("TopCenter");
		form.setTopCenter(topCenter);

		Label topRight = new Label(form, SWT.BORDER);
		topRight.setText("TopRight");
		form.setTopRight(topRight);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![ViewForm]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_viewform.gif)

### Layout

1. 如果没有Top控件，则Content会默认的填充整个ViewForm。
2. TopLeft的控件会在水平方向上挤占剩余的空间，而TopRight和TopCenter只会占用自己合适的空间。
3. TopRight和TopCenter都是默认从右边排列的，如果没有设置则不留位置。


***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[CLabel Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/CLabel-Tutorial) 下一篇：[StyledText Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/StyledText-Tutorial)