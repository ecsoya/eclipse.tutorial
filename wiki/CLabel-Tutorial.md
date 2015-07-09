---
layout: page
title: CLabel Tutorial
wikiPageName: CLabel-Tutorial
menu: wiki
---

CLabel和[Label](http://ecsoya.github.io/eclipse.tutorial/wiki/Label-Tutorial)类似，都是用来显示文字和图片的组件。

### CLabel vs Label
1. 一个Label只能设置文字或图片的一种，而CLabel能同时显示文字和图片。
2. Label还用来显示分割线，但CLabel不能。
3. 当文本比较长而组件的宽度不够时，Label和CLable的处理方式也不一样：
	* Label会只显示前面的一部分。
	* CLabel会把最前面和最后面的文字显示出来，中间用省略号代替。

### CLabel的省略规则
当没有足够的空间来显示内容的时候，CLabel会使用一下规则：

1. 左对齐的情况下，会忽略默认的缩进值。
2. 忽略图片，以及图片和文本之间的间隔值。
3. 会用省略号（...）来替换文本中间的值。
4. 如果只有图片，而控件不够的话，图片则不会被显示。

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[SashForm Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/SashForm-Tutorial) 下一篇：[ViewForm Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/ViewForm-Tutorial)