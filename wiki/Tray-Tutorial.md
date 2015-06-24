---
layout: page
title: Tray Tutorial
wikiPageName: Tray-Tutorial
menu: wiki
---

`Tray`和`TrayItem`是指在任务栏上的能代表程序的图标，和前面提到的[TaskBar]({{site.baseurl}}/wiki/TaskBar-Tutorial.html)类似。比如我们常见的`QQ，Skype`等程序运行之后，在屏幕的右下角会有一个图标

先看一个示例吧：

		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Tray Tutorial");
		shell.setSize(300, 200);

		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.spacing = 0;
		shell.setLayout(layout);

		Image image = new Image(display,
				TrayTutorial.class.getResourceAsStream("task.gif"));

		CLabel label = new CLabel(shell, SWT.CENTER);
		Tray tray = display.getSystemTray();
		if (tray == null) {
			label.setText("This platform does NOT support the tray.");
		} else {
			label.setText("Please visit the icon ");
			new CLabel(shell, SWT.CENTER).setImage(image);
			new CLabel(shell, SWT.CENTER).setText(" on System TaskBar.");
			// Create tray item.
			TrayItem item = new TrayItem(tray, SWT.NONE);
			// Set images.
			item.setImage(image);
			item.setHighlightImage(image);

			// Add tool tip.
			final ToolTip toolTip = new ToolTip(shell, SWT.BALLOON);
			toolTip.setText("Foxes vs. Dogs");
			toolTip.setMessage("A quick brown fox jumps over the lazy dog.");
			item.setToolTip(toolTip);

			// Add Selection and DefaultSelection Listener.
			item.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					shell.moveAbove(null);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					toolTip.setVisible(true);
				}
			});

			// Add Menu Listener.
			final Menu menu = new Menu(shell, SWT.POP_UP);
			for (int i = 0; i < 5; i++) {
				MenuItem menuItem = new MenuItem(menu, SWT.NONE);
				menuItem.setImage(image);
				menuItem.setText("MenuItem - " + i);
			}
			new MenuItem(menu, SWT.SEPARATOR);
			MenuItem exit = new MenuItem(menu, SWT.NONE);
			exit.setText("Exit");
			exit.addListener(SWT.Selection, new Listener() {

				@Override
				public void handleEvent(Event event) {
					shell.dispose();
				}
			});

			item.addMenuDetectListener(new MenuDetectListener() {

				@Override
				public void menuDetected(MenuDetectEvent e) {
					menu.setVisible(true);
				}
			});
		}

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		image.dispose();
		display.dispose();

运行此段代码，会在TaskBar上出现一个图标，双击会出现ToolTip，右键点击会出现菜单。

***
参考资料：
  * [Tray, TrayItem snippets](http://www.eclipse.org/swt/snippets/#tray)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[ToolTip Tutorial]({{site.baseurl}}/wiki/ToolTip-Tutorial.html)
下一篇：[Link Tutorial]({{site.baseurl}}/wiki/Link-Tutorial.html)
