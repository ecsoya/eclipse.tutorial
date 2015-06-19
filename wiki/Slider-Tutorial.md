---
layout: page
title: Slider Tutorial
wikiPageName: Slider-Tutorial
menu: wiki
---

滑动条（Slider）与上篇讲过的[刻度条（Scale）]({{site.baseurl}}/eclipse.tutorial/wiki/Scale-Tutorial.html)的用法基本类似，也分为水平的和垂直的两类，并且和滚动条（ScrollBar）长得非常相似

本篇就不再赘述，只有一点不同，就是滑动条可以设置滑动柄（Thumb）的大小，最小值为1，最大值不能超过有效范围（Maximum减去Minimum）。
		
        Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Slider Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		Slider vSlider = new Slider(shell, SWT.VERTICAL);
		vSlider.setMaximum(100);
		vSlider.setThumb(20);

		Slider hSlider = new Slider(shell, SWT.HORIZONTAL);
		hSlider.setMaximum(100);
		hSlider.setSelection(50);
		hSlider.setThumb(10);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_slider.png)

***
参考资料：
  * [Slider snippets](http://www.eclipse.org/swt/snippets/#slider)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Scale Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Scale-Tutorial.html)
下一篇：[Spinner Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Spinner-Tutorial.html)

