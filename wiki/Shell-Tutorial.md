---
layout: page
title: Shell Tutorial
wikiPageName: Shell-Tutorial
menu: wiki
---

`Shell`在前面的章节中已经经常出现，想你也不太陌生了，它就是用来创建窗口的。在这里主要讲讲`Shell`的不同类型的`style`。

### Decoration Styles

**1. SWT.NO_TRIM**：`没有任何装饰的窗口，如标题栏，边框等。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_no_trim.png)

**2. SWT.CLOSE**：`有标题栏和边框的窗口，并且在右上角有一个关闭按钮。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_close.png)

**3. SWT.TITLE**：`有标题栏和边框的窗口，能设置标题。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_title.png)

**4. SWT.MIN**：`有标题栏和边框的窗口，有最小化，最大化（不可用）和关闭的按钮。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_min.png)

**5. SWT.MAX**：`有标题栏和边框的窗口，有最小化（不可用），最大化和关闭的按钮。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_max.png)

**6. SWT.BORDER**：`有普通边框的窗口。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_border.png)

**7. SWT.RESIZE**：`有边框的窗口，窗口可以调整大小。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_resize.png)

**8. SWT.ON_TOP**：`窗口在所有窗口的最上面，且任务栏上没有图标，与Menu类似。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_on_top.png)

**9. SWT.TOOL**：`有普通边框(各边的线宽为1个像素)的窗口。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_tool.png)

**10. SWT.SHEET**：`标题栏，边框都有的完整的窗口。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_sheet.png)

**11. SWT.SHELL_TRIM**：`相当于SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX | SWT.RESIZE。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_shell_trim.png)

**12. SWT.DIALOG_TRIM**：`相当于SWT.TITLE | SWT.CLOSE | SWT.BORDER。` 

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_shell_dialog_trim.png)

### Modality Styles

1. **SWT.MODELESS**：`相对自由的窗口，所有的Shell之间不会锁死。默认为此。`
2. **SWT.PRIMARY_MODAL**：`当前创建的Shell会把父Shell中创建的所有Shell锁死，只有当前的Shell关闭之后，其它的才能用。`
3. **SWT.APPLICATION_MODAL**：`当前的Shell会把当前Display上所有的Shell都锁死。`
4. **SWT.SYSTEM_MODAL**：`当前的Shell会把所有Display上的Shell都锁死。`

_**注意**_：Modality Style的级别从上往下一个比一个高，但是不是所有的系统都支持这些特性。

***
参考资料：
  * [Shell snippets](http://www.eclipse.org/swt/snippets/#shell)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Components Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Components-Tutorial.html)
下一篇：[Display Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Display-Tutorial.html)
