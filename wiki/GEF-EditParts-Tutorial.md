---
layout: page
title: GEF EditParts Tutorial
wikiPageName: GEF-EditParts-Tutorial
menu: wiki
---

EditPart是GEF构建图形化编辑器的关键，每一个EditPart就标识一种模型，同时它也是GEF（MVC）里面的控制器（Controller）部分。

在GEF中，常用的EditPart可以分为三类：

* GraphicalEditPart
* TreeEditPart
* RootEditPart

### GraphicalEditPart

GraphicalEditPart应用在GraphicalViewer中，用来创建一些使用Draw2d Figure绘制的图形或者连线。

我们常用的GraphicalEditPart有一下几种：

1. **Graphical EditPart**：普通的图形化的EditPart。
2. **NodeEditPart**：能够作为连线的起点或终点的EditPart，也就是说，如果你的模型想要被连线，就必须继承这个接口。
3. **ConnectionEditPart** ：连线的EditPart，Figure为Connection接口。

### TreeEditPart

TreeEditPart应用在TreeViewer（GEF，不是JFace）中，用来创建一些使用SWT TreeItem绘制的树状结构。通常在GEF编辑器的大纲视图（outline）中使用。

用法比较简单，只需要继承`org.eclipse.gef.editparts.AbstractTreeEditPart`并重写里面的getText()和getImage()方法即可。


### RootEditPart

RootEditPart是用来连接EditPartViewer以及EditPartViewer中的contents的，它还负责对整个GEF编辑器或视图的层（Layer）的管理。

RootEditPart一般不需要重写，

在ScrollingGraphicalViewer中常用的RootEditPart有两个：

* **org.eclipse.gef.editparts.ScalableRootEditPart**：这个RootEditPart是ScrollingGraphicalViewer里面设置的默认值。

* **org.eclipse.gef.editparts.ScalableFreeformRootEditPart**：使用这个RootEditPart的时候需要注意，顶层模型对应的Diagram的EditPart，必须要使用org.eclipse.draw2d.FreeformFigure作为Figure，如org.eclipse.draw2d.FreeformLayer。

>
> **FreeformFigure**的特点是：里面的元素的位置可以为负数。
> 

层的设置：
	
  		  Root Layered Pane 
    		├  Guide Layer 
    		├  Feedback Layer 
    		├  Handle Layer 
    		└  Scalable Layers (ScalableLayeredPane) 
      			├  Scaled Feedback Layer 
      			├  Printable Layers 
    				├ Connection Layer 
    				└ Primary Layer   
      			└  Grid Layer 
1. **Guide Layer**：用来显示Ruler和Guide，在显示尺度条（Ruler）的编辑器中，可以用来在Ruler上面创建一些Guide，Guide会有一些水平的或垂直的连线，编辑器中的图形会附着到这些线上面，然后移动Guide的时候，所有附着的图形都会跟着移动。   
![]({{site.baseurl}}/eclipse.tutorial/wiki/images/gef_guides.gif) 
2. **Feedback Layer**：用来显示一些操作的反馈信息，比如移动图形是的阴影等。    
![]({{site.baseurl}}/eclipse.tutorial/wiki/images/gef_feedbacks.gif) 
3. **Handle Layer**：用于显示一些图形工具，如常见的选中一个图形的时候，会有改变大小的工具。       
![]({{site.baseurl}}/eclipse.tutorial/wiki/images/gef_handles.gif)
4. **Scaled Feedback Layer**：显示支持缩放的Feedback。
5. **Connection Layer**：用来显示所有的连线。
6. **Primary Layer**：用来显示所有的图形。
7. **Grid Layer**：用来显示对齐用的格子（Grid）。    
![]({{site.baseurl}}/eclipse.tutorial/wiki/images/gef_grid.gif)


在TreeViewer中常用的有：

* **org.eclipse.gef.editparts.RootTreeEditPart**

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[GEF Editor Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-Editor-Tutorial) 下一篇：[GEF Figures Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-Figures-Tutorial)
