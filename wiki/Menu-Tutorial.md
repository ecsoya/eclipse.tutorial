---
layout: page
title: Menu Tutorial
wikiPageName: Menu-Tutorial
menu: wiki
---

`Menu`大致可以分为三类，一是窗口的菜单栏`（SWT.BAR）`，二是右键上下文菜单`（SWT.POP_UP）`，三是下拉菜单或子菜单`（SWT.DROP_DOWN）`。

下面是一段`Menu`的示例：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Menu Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		final Image image = new Image(display,
				MenuTutorial.class.getResourceAsStream("task.gif"));

		// MenuBar
		Menu menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setAccelerator('F');
		fileItem.setImage(image);

		// Drop_Down menu will be set as submenu for File menu.
		Menu fileItemMenu = new Menu(shell, SWT.DROP_DOWN); // Menu fileItemMenu = new Menu(fileItem);
		new MenuItem(fileItemMenu, SWT.PUSH).setText("Open...");
		new MenuItem(fileItemMenu, SWT.PUSH).setText("Exit");
		fileItem.setMenu(fileItemMenu);

		shell.setMenuBar(menuBar);

		Label label = new Label(shell, SWT.NONE);
		label.setText("Popup Menu");

		Menu contextMenu = new Menu(shell, SWT.POP_UP | SWT.NO_RADIO_GROUP);

		MenuItem pushItem = new MenuItem(contextMenu, SWT.PUSH);
		pushItem.setText("Push item");
		pushItem.setImage(image);

		new MenuItem(contextMenu, SWT.SEPARATOR);

		MenuItem checkItem1 = new MenuItem(contextMenu, SWT.CHECK);
		checkItem1.setText("Check item 1");
		checkItem1.setImage(image);
		checkItem1.setSelection(true);

		MenuItem checkItem2 = new MenuItem(contextMenu, SWT.CHECK);
		checkItem2.setText("Check item 2");
		checkItem2.setImage(image);

		new MenuItem(contextMenu, SWT.SEPARATOR);

		MenuItem radioItem1 = new MenuItem(contextMenu, SWT.RADIO);
		radioItem1.setText("Radio item 1");
		radioItem1.setImage(image);
		radioItem1.setSelection(true);

		MenuItem radioItem2 = new MenuItem(contextMenu, SWT.RADIO);
		radioItem2.setText("Radio item 2");
		radioItem2.setImage(image);
		radioItem2.setSelection(true);

		label.setMenu(contextMenu);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		image.dispose();
		display.dispose();

如图一是`Shell`的菜单栏：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_menu1.png)

如图二是右键上下文菜单：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_menu2.png)

### Menu

1. `只有Shell能添加MenuBar，并且Menu的style必须是SWT.BAR。`

        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);

2. `所有的Control都能添加ContextMenu，并且Menu的style必须是SWT.POP_UP。`

        Menu contetxMenu = new Menu(control, SWT.POP_UP);
        control.setMenu(contextMenu);

3. `如果Menu设置了SWT.NO_RADIO_GROUP属性，则所有的SWT.RADIO菜单会各自为组，否则，所有的SWT.RADIO菜单同为一组，只有一个会被选中。`

### MenuItem

1. SWT.CASCADE：`能拥有子菜单，并且子菜单的style必须为SWT.DROP_DOWN。`
2. SWT.PUSH：`普通菜单。`
3. SWT.CHECK：`多选项菜单。`
4. SWT.RADIO：`单选项菜单。`
5. SWT.SEPARATOR：`分割线，也用来对MenuItem进行分组。`
6. setText()：`设置显示的文本，若文本中含有“&”符号，则“&”符号之后的第一个字母会被设为快捷键。`

    menuItem.setText("&File");

    相当于设置：

    menuItem.setText("File");
    menuItem.setAccelerator('F');

    "File"菜单可用“Alt + F”快捷打开。
7. `setAccelerator()：设置快捷键。`

***
参考资料：
  * [Menu snippets](http://www.eclipse.org/swt/snippets/#menu)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[ExpandBar Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/ExpandBar-Tutorial.html)
下一篇：[Sash Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Sash-Tutorial.html)
