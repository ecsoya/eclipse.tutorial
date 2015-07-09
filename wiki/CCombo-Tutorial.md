---
layout: page
title: CCombo Tutorial
wikiPageName: CCombo-Tutorial
menu: wiki
---

`CCombo`和前面讲过的[Combo](http://ecsoya.github.io/eclipse.tutorial/wiki/Combo-Tutorial)是类似的，都是一个下拉式的列表框。

不同之处有：

1. Combo是调用的系统组件，而CCombo是用一个Composite模拟的。
2. CCombo没有使用SWT.SIMPLE属性，故不能展开成列表样式，详细请参考[Combo](http://ecsoya.github.io/eclipse.tutorial/wiki/Combo-Tutorial)。
3. CCombo能被画一个Flat按钮，而Combo不行。
4. CCombo的高度值可以更改，但Combo不行，在Table的CellEditor中使用的时候会有很明显的区别，如下图：

![Combo vs CCombo]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_ccombo.gif)


***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[SWT Custom Widgets Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/SWT-Custom-Widgts-Tutorial) 下一篇：[CCombo Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/CCombo-Tutorial)
