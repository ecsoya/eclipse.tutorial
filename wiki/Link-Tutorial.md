---
layout: page
title: Link Tutorial
wikiPageName: Link-Tutorial
menu: wiki
---

`Link`是一个可以显示超链接的组件，既可以设置普通的文本，又可以设置像`HTML`一样的超链接文本，如`<a href="url">Hyperlink</a>`的文本。

看示例：

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Link Tutorial");

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		Label label = new Label(shell, SWT.WRAP);
		label.setText("Try to click on the hyperlink of the Link\n(with yellow background).");
		Link link = new Link(shell, SWT.NONE);
		link.setText("1. Visit <a href=\"http://www.eclipse.org\">Eclipse</a> website,\n2. Visit <a href=\"http://www.soyatec.com\">Soyatec</a> website.");
		link.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
		final Label result = new Label(shell, SWT.NONE);
		link.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				result.setText(event.text);
			}
		});

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如下图所示：

**[[images/image_swt_link.png]]**

### 注意要点

1. `Selection事件的Event对象的Text会显示HTML标签<a>中HREF的内容。`

2. `这个是SWT控件，超连接并不会通过浏览器打开，如有需要，请自行设计。`

***
参考资料：
  * [Link snippets](http://www.eclipse.org/swt/snippets/#link)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Tray Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Tray-Tutorial)
下一篇：[Browser Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Browser-Tutorial)
