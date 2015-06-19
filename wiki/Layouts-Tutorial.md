---
layout: page
title: Layouts Tutorial
wikiPageName: Layouts-Tutorial
menu: wiki
---

# Layout Tutorial

`Layout`是用来控制容器（`Composite`）中控件的位置（`position`）和大小（`size`）的机制，前面我们也有提到，如果一个控件没有设置大小，它的默认值是0，就不会显示在界面中（`SWT`不像`swing/JavaFX`那样会给控件自动分配大小）。

既然说了控件的位置和大小，有一张图你一定会感兴趣：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/GeneralTerms.jpg)

`这张图详细的描述了Composite（图上是一个TabFolder）的位置相关的属性。`
  * `location：这个Composite的位置`。
  * `clientArea：这个Composite用来放置子控件的区域`。
  * `trim：这个控件用来放置抬头或标题的区域（普通的Composite没有此区域，像Shell，Group，TabFolder这些Composite都有）`。
  * `horizontal margin：水平方向的留白区域，左右两边都有，并且相同。`
  * `vertical margin`：垂直方向的留白区域，上下两边都有，并且相同。`
  * `horizontal spacing：水平方向上两个相邻控件之间的留白区域。`
  * `vertical spacing：垂直方向上两个相邻控件之间的留白区域。`

***
上面说了容器（Composite）中的放置控件的区域，那么关于具体的控件，怎么设置位置（position）和大小（size）呢？

  * `setLocation(x, y)：设置位置。`
  * `setSize(width, height)：设置大小。`
  * `setBounds(x, y, widht, height)：设置位置和大小。`
  * `computeSize(width, height)：计算出当前控件的最好或首选的大小。里面的参数可以用（SWT.DEFAULT）来代替，也可以给定具体的数值。一般情况下，在使用Layout布局的时候，如果对控件的大小没有具体的说明，都会调用此方法计算控件的大小。`
  * `setLayoutData(LayoutData)：这个方法是和父容器的Layout配套使用的，里面可以配置一些控件的具体参数，详细内容请参考各个Layout的实现。`

***
`SWT`中提供了一些标准的`Layout`类，当然，你也可以自定义一些`Layout`，但所有的`Layout`都必须继承自`org.eclipse.swt.widgets.Layout`类。

先看看SWT中的标准的Layout吧：它们都包含在`org.eclipse.swt.layout.*`包中。

  * [FillLayout]({{site.baseurl}}/eclipse.tutorial/wiki/FillLayout-Tutorial.html)
  * [RowLayout]({{site.baseurl}}/eclipse.tutorial/wiki/RowLayout-Tutorial.html)
  * [GridLayout]({{site.baseurl}}/eclipse.tutorial/wiki/GridLayout-Tutorial.html)
  * [FormLayout]({{site.baseurl}}/eclipse.tutorial/wiki/FormLayout-Tutorial.html)

在SWT的custom包中也有一个Layout，`org.eclipse.swt.custom.StackLayout`

  * [StackLayout]({{site.baseurl}}/eclipse.tutorial/wiki/StakLayout-Tutorial.html)

***
参考资料：

* [Understanding Layouts](http://www.eclipse.org/articles/article.php?file=Article-Understanding-Layouts/index.html)
