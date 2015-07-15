---
layout: page
title: JFace Viewers Tutorial
wikiPageName: JFace-Viewers-Tutorial
menu: wiki
---

JFace Viewer框架，允许你将你的模型直接显示到标准的SWT控件（如List，Combo，Table和Tree）上面去，熟悉SWT的人都知道，SWT中的控件一般都是是显示字符串或者图片的。


因此，要想准确的使用Viewer，必须要提供以下内容：

首先，你需要提供一个*content provider*去给Viewer提供相应的数据。

其次，你需要提供至少一个*label provider*将数据转化成字符串或图片显示到控件上面去。

### Viewer
* [TableViewer](http://ecsoya.github.io/eclipse.tutorial/wiki/TableViewer-Tutorial)
* [TreeViewer](http://ecsoya.github.io/eclipse.tutorial/wiki/TreeViewer-Tutorial)
* [ListViewer](http://ecsoya.github.io/eclipse.tutorial/wiki/ListViewer-Tutorial)
* [ComboViewer](http://ecsoya.github.io/eclipse.tutorial/wiki/ComboViewer-Tutorial)

### Content Provider

1. **IStructuredContentProvider**：在ListViewer，ComboViewer和TableViewer中使用，默认的可用*ArrayContentProvider*。
2. **ITreeContentProvider**：在TreeViewer中使用。

### Label Provider
1. **ILabelProvider**：在ListViewer，ComboViewer和TreeViewer中使用，可以为每一个元素提供一个图片和标签，默认可用*LabelProvider*。
2. **CellLabelProvider**：在TableViewer中使用，可以为每一个TableColumn提供一个label provider，默认可用*ColumnLabelProvider*。

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[JFace Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-Tutorial) 下一篇：[TableViewer Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/TableViewer-Tutorial)