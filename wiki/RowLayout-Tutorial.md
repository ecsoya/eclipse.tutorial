---
layout: page
title: RowLayout Tutorial
wikiPageName: RowLayout-Tutorial
menu: wiki
---

### 简介

`所有的控件按行或列排列`。

### 参数说明：

  * _**type**_：`SWT.HORIZONTAL或SWT.VERTICAL，FillLayout的类型，默认值为SWT.HORIZONTAL(水平方向或按行排列)。`
  * _**marginWidth**_：`水平方向两边的留白空间，左右两边的大小相同，默认为0。`
　* _**marginHeight**_：`垂直方向的两边的留白空间，上下两边的大小相同，默认为0。`
  * _**marginLeft**_：`位于左边界和控件之间的额外的留白区域，默认值为3。`
  * _**marginTop**_：`位于上边界与控件之间的额外的留白区域，默认值为3。`
  * _**marginRight**_：`位于右边界与控件之间的额外的留白区域，默认值为3。`
  * _**marginBottom**_：`位于下边界与控件之间的额外的留白区域，默认值为3。`
  * _**wrap**_：`当容器的大小改变而里面的控件不能显示在同一行或同一列时，需不需要自动换行或列。默认值为true。`
  * _**fill**_：`当设置为true时，如果按水平方向排列，则同一行上所有的控件的高度（height）一致；如果按垂直方向排列，同一列上的所有控件的宽度（width）一致。当设置为false时，则控件的高度或宽度保持自己的最小值。默认值为false。`
  * _**justify**_：`当设置为true时，同一列（行）上的所有控件平均分配行（列）的空间。反之，则是按控件的顺序和最小值排列。默认为false。`
  * _**center**_：`当设置为true时，控件会放置在自己所在的单元格的正中间，反之放在左上角。默认为false。`
  * _**pack**_：`当设为true时，各个控件的大小都会保持自己的最小值，反之，各个控件都会填充自己的单元格。默认为true。`
  * _**spacing**_：`相邻的两个控件之间的距离，默认值为3。`

### 参数设置效果：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_rowlayout.gif)

### RowData

在前面的章节有提到，子控件可以设置LayoutData来自定义一些属性，现在我们就来看看和RowLayout配套使用的org.eclipse.swt.layout.RowData吧。

  * _**height**_：`指定控件的高度值，在Layout的时候会根据它来计算控件的大小（即调用computeSize(width, height)），默认为SWT.DEFAULT。`
  * _**width**_：`指定控件的宽度值，在Layout的时候会根据它来计算控件的大小（即调用computeSize(width, height)），默认为SWT.DEFAULT。`
  * _**exclude**_：`当设置为true的时候，Layout会忽略它的存在，不给它分配空间。默认为false。`

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
