---
layout: page
title: GEF Tutorial
wikiPageName: GEF-Tutorial
menu: wiki
---

[Graphical Editing Framework(GEF)](http://www.eclipse.org/gef/)是eclipse中用来创建图形化编辑器和视图的一组插件。

GEF3.x版本包含的的主要组件有Draw2d，GEF（MVC）和Zest。

### Draw2d

Draw2d是基于SWT的一组用来显示和布局图形的组件，所有的图形（Figure）都是轻量级的，能够显示在SWT Canvas之上。


> 
> 所谓的轻量级，其实是相对于SWT的具体的控件来说的，SWT中的所有的控件，在使用完成之后都必须销毁。
> 
> Draw2d只是使用了SWT的Canvas，所哟的图形都是在Canvas上画出来的。
> 

### GEF (MVC)

GEF的核心是一个基于Draw2d的MVC架构，旨在构建基于模型的图形化的编辑器。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/gef_mvc.gif)

### Zest

Zest旨在构建基于Draw2d的图形化视图。 

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 下一篇：[GEF Editor Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-Editor-Tutorial)
