---
layout: page
title: Resource Management Tutorial
wikiPageName: Resource-Management-Tutorial
menu: wiki
---

Resource（org.eclipse.swt.graphics.Resource） Management指的是SWT中依赖系统的一些绘图资源的创建，销毁等的管理，我们常用的有：

* [Color](http://ecsoya.github.io/eclipse.tutorial/wiki/Color-Tutorial)
* [Font](http://ecsoya.github.io/eclipse.tutorial/wiki/Font-Tutorial)
* [Image](http://ecsoya.github.io/eclipse.tutorial/wiki/Image-Tutorial)
* Cursor
* GC：GC是SWT中用来支持绘制功能的一个重要组件，它可以支持在Image上面或是控件（Control）绘制图形，甚至也可以直接在Display上绘制任意的图形。
* Path：Path是SWT中绘图的一个重要组件，它用来描述某个图形在二维空间中的路径，它能够用点，线，面等一系列的二维元素来描述。
* Parttern：主要用来描述一些绘制阴影，图片等信息。
* Region：可以参考给Control设置Region。
* TextLayout：主要在StyledText中使用，用来布局StyledText中的文本。
* Transform：主要用于对一些几何矩阵的转换，比如旋转，移动等。

### 创建

一般情况下，我们都需要传入一个Device示例，比如Display或Printer来完成Resource对象的创建。

	Color color = new Color(display);

### 销毁

当Resource用完之后，必须要调用Resource.dispose()方法将之销毁，以便释放空间。

反之，如果Resource被销毁之后，便不能再被使用，可以调用isDisposed()方法去辨别是否被销毁。

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[StackLayout Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/StackLayout-Tutorial) 下一篇：[Color Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Color-Tutorial)
