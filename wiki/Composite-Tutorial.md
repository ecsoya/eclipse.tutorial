---
layout: page
title: Composite Tutorial
wikiPageName: Composite-Tutorial
menu: wiki
---

`Composite` 是 `SWT` 中最常用的一个容器，子控件一般情况下都会由设置的 [Layout]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html) 来分配空间

1. `Composite 默认是没有边框的，如果要显示边框，请在初始化的时候加上 SWT.BORDER。`
2. `SWT.H_SCROLL 和 SWT.V_SCROLL 可以给 Composite 加上滚动条，但滚动条的实现需要自己完成，参照示例：`[scroll a child control automatically](http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet9.java)，`另外，如果你想用现成的带滚动条的 Composite, 请参考`[ScrolledComposite](http://www.eclipse.org/swt/snippets/#scrolledcomposite)`的示例`。
3. `setTabList（）：设置点击Tab键时获得焦点（focus）的控件的列表。参考示例：`[set the tab traversal order of children](http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet75.java)
4. `SWT.NO_RADIO_GROUP是针对单选按钮（Button(SWT.RADIO)）的一个特殊的参数，当Composite设置了此参数之后，里面所有的Radio都是各自为一组，也就是说都成了多选（SWT.CHECK）按钮了。参考示例：`[force radio behavior on two different composites](http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet115.java)
5. `背景模式setBackgroundMode()，SWT.INHERIT_NONE，SWT.INHERIT_DEFAULT 和 SWT.INHERIT_FORCE 三选一。参考示例：`[inherit a background color or image](http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet237.java)

***
参考资料：
  * [Composite snippets](http://www.eclipse.org/swt/snippets/#composite)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

下一篇：[Canvas Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Canvas-Tutorial.html)
