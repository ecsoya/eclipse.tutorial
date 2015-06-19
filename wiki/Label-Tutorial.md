---
layout: page
title: Label Tutorial
wikiPageName: Label-Tutorial
menu: wiki
---

标签（Label）一般情况下，就是用来显示一段文字或是图片的控件。在SWT中Label的实现类是`org.eclipse.swt.widgets.Label`，但是这个Label类，不但可以构造普通的标签，也可以构造分割线（Separator），关键取决于你所用的Style。

### 1. 显示文本或图片的Label.
    Label textLabel= new Label(shell, SWT.NONE);
    textLabel.setText("Hello, I am a Label.");

    Label imageLabel = new Label(shell, SWT.BORDER);
    imageLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_label_1.png)

**Tips**: 
  1. `一个Label，不能同时显示文本和图片，只能二选一。`
  2. `SWT.BORDER, 是指给Label定义了一个边框（Border）。` 

### 2. 分割线（Separator）
    new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
    new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_label_2.png)

很简单吧？没错，两点:
  1. `SWT.SEPARATOR`；
  2. `SWT.HORIZONTAL`或`SWT.VERTICAL`，顾名思义，分割线的方向。

### 3. 文本或图片的对齐（Alignment）
Label提供了三种对齐的方式：左对齐（`SWT.LEFT`）,居中对齐（`SWT.CENTER`）和右对齐（`SWT.RIGHT`），默认为左对齐。

设置方法有两种:
  1. 在创建的时候，加到style中，比如：

        Label label = new Label(shell, SWT.CENTER);

  2. 通过调用setAlignment()方法。

        Label label = new Label(shell, SWT.NONE);
        label.setAlignment(SWT.CENTER);

来个完整的例子：

        Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Alignment Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(3, true));

		Label leftLabel = new Label(shell, SWT.LEFT|SWT.BORDER);
		leftLabel.setText("Left");
		leftLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		Label centerLabel = new Label(shell, SWT.CENTER | SWT.BORDER);
		centerLabel.setText("Center");
		centerLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		Label rightLabel = new Label(shell, SWT.BORDER);
		rightLabel.setText("Right");
		rightLabel.setAlignment(SWT.RIGHT);
		rightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		

		Label imageLeftLabel = new Label(shell, SWT.BORDER);
		imageLeftLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageLeftLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

		Label imageCenterLabel = new Label(shell, SWT.BORDER | SWT.CENTER);
		imageCenterLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageCenterLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		Label imageRightLabel = new Label(shell, SWT.BORDER | SWT.RIGHT);
		imageRightLabel.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		imageRightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
上图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_label_3.png)

### 4. 文本自动换行（Wrap）

遇到比较长分文本，而标签的宽度又不够时怎么办？别着急，可以试试自动换行（`SWT.WRAP`）。
请看下面的例子：

        Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Label Wrap Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(2, true));

		Label noWrapLabel = new Label(shell, SWT.BORDER);
		noWrapLabel.setText("This is a long Text on label, but no WRAP style set.");
		noWrapLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		
		Label wrapLabel = new Label(shell, SWT.WRAP | SWT.BORDER);
		wrapLabel.setText("This is a long Text on label, and the WRAP style is set.");
		wrapLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));


		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_label_4.png)

一目了然吧？

参考资料：
  * [Label snippets](http://www.eclipse.org/swt/snippets/#label)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Widgets Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/SWT-Widgets.html)
下一篇：[Button Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Button-Tutorial.html)
