---
layout: page
title: Browser Tutorial
wikiPageName: Browser-Tutorial
menu: wiki
---

浏览器`（Browser）`是`SWT`中的一个非常重要的组件，但其实它只是一个壳，它调用了各个系统中的默认的浏览器`（如Windows IE，Linux Mozilla Firefox 和 Mac Safari）`的实现方法，也就是说，如果系统中没有安装浏览器，`SWT`的`Browser`也将不能用。

先看一段简单的示例：

		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Browser Tutorial");
		shell.setLayout(new FillLayout());
		Browser browser = null;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			/*
			 * The Browser widget throws an SWTError if it fails to instantiate
			 * properly. Application code should catch this SWTError and disable
			 * any feature requiring the Browser widget. Platform requirements
			 * for the SWT Browser widget are available from the SWT FAQ
			 * website.
			 */
		}
		if (browser != null) {
			/* The Browser widget can be used */
			browser.setUrl("http://www.eclipse.org");
		}
		shell.setSize(400, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

此段代码在`Windows`下如图：

**[[images/image_swt_browser.png]]**

### 常用方法

1. `setUrl()：设置URL。`
2. `setText()：设置HTML文本。`
3. `back()：回退。`
4. `forward()：向前。`
5. `stop()：停止。`
6. `refresh()：刷新。`

***
参考资料：
  * [Browser snippets](http://www.eclipse.org/swt/snippets/#browser)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Link Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Link-Tutorial)
下一篇：[Dialog Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Browser-Tutorial)
