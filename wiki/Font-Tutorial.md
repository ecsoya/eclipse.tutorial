---
layout: page
title: Font Tutorial
wikiPageName: Font-Tutorial
menu: wiki
---

Font是文字编辑和显示的最重要的元素，SWT中的Font主要通过定义FontData来完成。

### FontData
FontData的组成有：

* **name**：字体名称。
* **height**：字体大小。
* **style**：字体的样式。
	* **SWT.BLOD**
	* **SWT.ITALIC**
	* **SWT.NORMAL**

### 默认字体

	Display.getSystemFont();

### FontDialog

	FontDialog dlg = new FontDialog(shell);
	FontData newFont = dlg.open();

### 参考资料
1. [Font snippets](http://www.eclipse.org/swt/snippets/#font)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Color Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Color-Tutorial) 下一篇：[Image Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Image-Tutorial)
