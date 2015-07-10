---
layout: page
title: Color Tutorial
wikiPageName: Color-Tutorial
menu: wiki
---

Color的使用，首先要了解RGB。

RGB有两种创建方式：

1. 是使用Red，Green和Blue三色比重的方式，这三色都是介于1~255之间的整数值。
2. 是使用HSB（色相Hue/饱和度Saturation/亮度Brightness）的方式，其中Hue的取值范围是0~360的浮点数，Saturation和Brightness的取值范围是0~1的浮点数。

示例：

	Color color = new Color(display, 0, 0, 0);

或

	Color color = new Color(display, new RGB(0, 0, 0));

### ColorDialog

ColorDialog是SWT中用来选取颜色的对话框，它是通过设置RGB值来使用的，同时，它的返回值也是RGB。

### 参考资料
1. [Color and RGB snippets](http://www.eclipse.org/swt/snippets/#color)

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Resource Management Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Resource-Management-Tutorial) 下一篇：[Font Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Font-Tutorial)