---
layout: page
title: FormLayout Tutorial
wikiPageName: FormLayout-Tutorial
menu: wiki
---

FormLayout是一个能控制控件的上下左右各边的位置和大小的Layout。

### FormLayout
* **Margins**
	* **marginLeft**：距左边留白。
	* **marginRight**：距右边留白。
	* **marginTop**：距上边留白。
	* **marginBottom**：距下边留白。
	* **marginWidth**：左右两边的留白。
	* **marginHeight**：上下两边的留白。
* **Spacings**：相邻两个控件之间的距离。

示例：

 		Display display = new Display ();
		Shell shell = new Shell(display);
		FormLayout layout = new FormLayout();
		layout.marginWidth = 3;
		layout.marginHeight = 3;


		FormData data1 = new FormData();
		data1.left = new FormAttachment(0, 0);
		data1.top = new FormAttachment(0, 0);
		button1.setLayoutData(data1);
		FormData data2 = new FormData();
		data2.left = new FormAttachment(button1);
		data2.top = new FormAttachment(0, 0);
		data2.right = new FormAttachment(100, 0);
		button2.setLayoutData(data2);


### FormData
* **Prefered Size**：控件大小的首选值，将会在调用Control.computeSize(int, int, boolean)计算控件大小的时候使用，默认值为SWT.DEFAULT。
	* **width**：
	* **height**：
* **Attachments**：用来计算控件上下左右各边的位置。
	* **left**：
	* **top**：
	* **right**：
	* **bottom**：

示例：

 		FormData data = new FormData();
 		data.left = new FormAttachment(0,5);
 		data.right = new FormAttachment(100,-5);
 		button.setLayoutData(formData);
 

### FormAttachment
FormAttachment有两种类型：一是基于数学比值的，二是基于其中的某一个控件（Control）的。

* **Mathematical Fraction**：基于容器的大小和自己的比重计算位置。
	* **numerator**：分子，容器宽度或高度的几分之几。
	* **denominator**：分母，容器宽度或高度的几分之几，不能为0，默认为100。
	* **offset**：偏移量。
* **Control Based**：基于给定的容器中的其它控件。
	* **control**：容器中已有的控件。
	* **offset**：偏移量。
	* **alignment**：对齐方式，根据给定的上下左右边或居中对齐，默认的DEFAULT为跟距离最近的一条边对齐。
		* **TOP**
		* **BOTTOM**
		* **RIGHT**
		* **LEFT**
		* **CENTER**
		* **DEFAULT**

示例：

 		FormData data = new FormData();
 		data.top = new FormAttachment(0,5);
 		data.bottom = new FormAttachment(100,-5);
 		data.left = new FormAttachment(0,5);
 		data.right = new FormAttachment(100,-5);
 		button.setLayoutData(data);


### 参考资料

1. [FormLayout snippets](http://www.eclipse.org/swt/snippets/#formlayout)
2. [SWT Example: LayoutExample](http://www.eclipse.org/swt/examples.php)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[GridLayout Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/GridLayout-Tutorial.html) 下一篇：[StackLayout Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/StakLayout-Tutorial.html)
