---
layout: page
title: CTabFolder Tutorial
wikiPageName: CTabFolder-Tutorial
menu: wiki
---

CTabFolder的用法和[TabFolder](http://ecsoya.github.io/eclipse.tutorial/wiki/TabFolder-Tutorial)的用法类似，但是TabFolder是系统组件，有很多局限性，而CTabFolder是通过Composite定制的，里面很多有用的功能，最经典的例子就是Eclipse中的每一个视图（View）就是一个CTabFolder。

### 特性
1. **SWT.CLOSE**：在每一个Tab页上面可以显示一个关闭按钮。
2. **Top Right**：在显示Tab的右边空白处，可以设置一些其它的组件，比如ToolBar，然后显示一些有用的工具，还可以直接显示最小化和最大化的按钮，参考Eclipse视图。
3. **Simple Tabs**：改变Tab显示的风格，Simple为垂直的，非Simple为带弧度的。
4. **Single Tab**：当前只显示一个Tab页。
5. **Image on Tab**：可以给Tab页设置不同的图片。


> 也可以说，CTabFolder就是完全的为Eclipse视图的显示定制的。

### 参考资料
1. [CTabFolder, CTabItem snippets](http://www.eclipse.org/swt/snippets/#ctabfolder)
2. [SWT Example: CustomControlExample](http://www.eclipse.org/swt/examples.php)

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[CCombo Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/CCombo-Tutorial)  下一篇：[SashForm Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/SashForm-Tutorial)
