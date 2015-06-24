---
layout: page
title: Common Properties Tutorial
wikiPageName: Common-Properties-Tutorial
menu: wiki
---

前面我们已经说过，SWT的控件都是通过JNI调用系统资源的方式创建的，里面的大多数控件都能够设置和系统的UI控件极为相似的风格和属性。但也有个别的控件，由于系统的开放程度，某些属性会受限。这一篇主要讲一些控件的基本属性。

### 1. 设置背景色（Background Color）

    setBackground(color); 

关于`Color`的详细定义，请参考[Resource Management]({{site.baseurl}}/wiki/Resource-Management-Tutorial.html)

### 2. 设置前景色（Foreground Color）

    setForeground(color);

关于`Color`的详细定义，请参考[Resource Management]({{site.baseurl}}/wiki/Resource-Management-Tutorial.html)

### 3. 设置字体（Font）

    setFont(font);

关于`Font`的详细定义，请参考[Resource Management]({{site.baseurl}}/wiki/Resource-Management-Tutorial.html)

### 4. 设置背景图片（Background Image）

    setBackgroundImage(image);

关于`Image`的详细定义，请参考[Resource Management]({{site.baseurl}}/wiki/Resource-Management-Tutorial.html)

### 5. 设置可见性（Visible）

    setVisible(true|false);

### 6. 设置可用性（Enable）

    setEnable(true|false);

### 7. 设置菜单（Popup Menu）

    setMenu(menu);

关于`Menu`的定义，请参考[Menu Tutorial]({{site.baseurl}}/wiki/Menu-Tutorial.html)

### 8. 设置方向（Orientation）

    setOrientation(SWT.LEFT_TO_RIGHT|SWT.RIGHT_TO_LEFT);

在默认情况下，所有的控件的内容（文本，图片等）都是从左至右（`SWT.LEFT_TO_RIGHT`）排列的，也可以根据需要设定为从右至左（`SWT.RIGHT_TO_LEFT`），但你要注意，设置为从右至左之后，所有的`Alignment`属性设置都会相反。

***
参考资料：
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Dialog Tutorial]({{site.baseurl}}/wiki/Dialog-Tutorial.html)
下一篇：[Components Tutorial]({{site.baseurl}}/wiki/Components-Tutorial.html)
