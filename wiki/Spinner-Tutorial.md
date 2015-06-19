---
layout: page
title: Spinner Tutorial
wikiPageName: Spinner-Tutorial
menu: wiki
---

Spinner和前两篇中的[Scale]({{site.baseurl}}/eclipse.tutorial/wiki/Scale-Tutorial)和[Slider]({{site.baseurl}}/wiki/Slider-Tutorial.html)的用法也非常相似，不过它可以用来设置一些复杂的数值（如float型的或是double型的）

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Spinner Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		final Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setMinimum(-10000);
		spinner.setMaximum(10000);
		spinner.setDigits(2);
		spinner.setSelection(-248);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_spinner.png)

***
### 需要注意的地方：

* `Spinner的最小值（minimum）可以设置为负数，而Scale和Slider都不行。`
* `setDigits()方法用来设置精度，如果设置为2，就表示小数点后有2位数。`
* `当精度不为0时，通过getSelection()得到的值不是最终的数值，必须要除以精度。比如上面的示例中，精度为2，通过getSelection()方法，我们得到的值是248，于是我们最终需要的除以精度数值就为2.48。`
* `同样的，当精度不为0时，调用setSelection()的值必须要乘以精度。比如上面的例子中，要让Spinner选中2.48，必须输入selection的值为248。`
* `由于Spinner可以有一个可供输入的文本框，可以设置为只读，也可以设置为读写（当然了，只能输入数字），所以Spinner可以添加Modify事件。`

***
参考资料：
  * [Spinner snippets](http://www.eclipse.org/swt/snippets/#spinner)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Slider Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Slider-Tutorial.html)
下一篇：[DateTime Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/DateTime-Tutorial.html)
