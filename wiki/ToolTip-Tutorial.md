---
layout: page
title: ToolTip Tutorial
wikiPageName: ToolTip-Tutorial
menu: wiki
---

`SWT`中，`ToolTip`有两种，一种是直接给控件`（Control或Item）`设置`ToolTipText`，另一种是调用`org.eclipse.swt.widgets.ToolTip`控件。

先看一段示例：

		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ToolTip Tutorial");
		shell.setSize(450, 200);

		shell.setLayout(new GridLayout());

		// 1. Add tooltip for Shell.
		shell.setToolTipText("ToolTip Tutorial: this is a simple tooltip text for Shell.");

		// 2. Create a normal tooltip Widget.
		final ToolTip tip = new ToolTip(shell, SWT.NONE);
		tip.setText("Foxes vs. Dogs");
		tip.setMessage("The quick brown fox jumps over the lazy dog.");
		tip.setAutoHide(false);
		final Button showTipButton = new Button(shell, SWT.NONE);
		showTipButton.setText("Show ToolTip");
		showTipButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (tip.isVisible() || tip.isDisposed()) {
					return;
				}
				Rectangle r = showTipButton.getBounds();
				Point pt = showTipButton.toDisplay(r.x + r.width + 50, r.y);
				tip.setLocation(pt);
				tip.setVisible(true);
			}
		});

		// 3. Create a tooltip Widget which looks like a balloon.
		final ToolTip balloon = new ToolTip(shell, SWT.BALLOON
				| SWT.ICON_INFORMATION);
		balloon.setText("Foxes vs. Dogs");
		balloon.setMessage("The quick brown fox jumps over the lazy dog.");
		balloon.setAutoHide(true);

		final Button showTipButton2 = new Button(shell, SWT.NONE);
		showTipButton2.setText("Show Balloon ToolTip");
		showTipButton2.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (balloon.isVisible() || balloon.isDisposed()) {
					return;
				}
				Rectangle r = showTipButton2.getBounds();
				Point pt = showTipButton2.toDisplay(r.x + r.width, r.y);
				balloon.setLocation(pt);
				balloon.setVisible(true);
			}
		});

		Button closeTipButton = new Button(shell, SWT.NONE);
		closeTipButton.setText("Close");
		closeTipButton.setToolTipText("Close all tooltips.");
		closeTipButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (!balloon.isDisposed()) {
					balloon.setVisible(false);
				}
				if (!tip.isDisposed()) {
					tip.setVisible(false);
				}
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图一，Shell的ToolTip：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_tooltip1.png)

如图二，普通的ToolTip控件：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_tooltip2.png)

如图三，气泡状的ToolTip控件：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_tooltip3.png)

### 控件的设置ToolTip设置

调用setToolTipText()方法，当鼠标移动到控件上时，自动显示ToolTip，并且会自动销毁。

### ToolTip控件

**1. 创建**

`SWT.BALLOON为气泡状的，默认为普通的。`

    ToolTip toolTip = new ToolTip(shell, SWT.BALLOON);

**2. 添加图片** 

`SWT.ICON_ERROR，SWT.ICON_INFORMATION和SWT.ICON_WARNING三选一。`

    ToolTip toolTip = new ToolTip(shell, SWT.BALLON | SWT.ICON_ERROR);

**3. 添加信息（Message）**

    toolTip.setMessage("Your message.");

**4. 添加标题（Text）**

    toolTip.setText("Your ToolTip Title.");

**5. 设置自动隐藏（autoHide），默认为true。**

    toolTip.setAutoHide(false);

**6. 打开或关闭**

    toolTip.setVisible(true|false);

***
参考资料：
  * [Tool Tips snippets](http://www.eclipse.org/swt/snippets/#tooltips)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[Sash Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Sash-Tutorial.html)
下一篇：[Tray Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Tray-Tutorial.html)
