---
layout: page
title: TaskBar Tutorial
wikiPageName: TaskBar-Tutorial
menu: wiki
---

TaskBar是系统任务栏，一般情况下，程序运行起来之后，在系统任务栏上都会有一个任务图标，用来快速切换任务。SWT提供了一些可以自定义这个任务图标的方法。

第一步：要通过Display取得当前的系统任务栏（TaskBar）

    TaskBar taskBar = display.getSystemTaskBar();

第二步：取得当前程序或是窗口的具体的任务图标（TaskItem）。

		TaskItem item = taskBar.getItem(shell);
		if (item == null) {
			item = taskBar.getItem(null);
		}
第三步：如果TaskItem不是空的，就可以进行一下设置了：

  * `item.setOverlayImage(display.getSystemImage(SWT.ICON_ERROR));` ![]({{site.baseurl}}/wiki/images/image_swt_taskbar_overlayimage.png)
  * `item.setOverlayText("OK");` ![]({{site.baseurl}}/wiki/images/image_swt_taskbar_overlaytext.png)
  * `item.setProgress(50);` 设置进度。
  * `item.setProgressState(SWT.NORMAL);` ![]({{site.baseurl}}/wiki/images/image_swt_taskbar_normal.png)
  * `item.setProgressState(SWT.ERROR);` ![]({{site.baseurl}}/wiki/images/image_swt_taskbar_error.png)
  * `item.setProgressState(SWT.PAUSED);` ![]({{site.baseurl}}/wiki/images/image_swt_taskbar_paused.png)

注意：

1. `overlayImage和overlayText只能设置一个，并且，overlayText也不要太长，地方就那么点，太长了也显示不了。`

2. `ProgressState：可选项有5个`，
  * `SWT.NORMAL，SWT.ERROR和SWT.PAUSED是和setProgress()配合使用的。`
  * `SWT.DEFAULT：默认值，一般不会显示进度。`
  * `SWT.INDETERMINATE: 就是进度条会一直循环滚动，根据系统来定，貌似Windows7就没有实现，Mac OS下有实现。`

***
参考资料：
  * [Taskbar snippet](http://www.eclipse.org/swt/snippets/#taskbar)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[ScrollBar Tutorial]({{site.baseurl}}/wiki/ScrollBar-Tutorial.html)
下一篇：[ExpandBar Tutorial]({{site.baseurl}}/wiki/ExpandBar-Tutorial.html)
