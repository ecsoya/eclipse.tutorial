---
layout: page
title: SWT Widgets
wikiPageName: SWT-Widgets
menu: wiki
---

SWT中包含了很多常用的控件，如`Button`，`Text`，`Menu`等等。你可以从`org.eclipse.swt.widgets`或`org.eclipse.swt.custom`包中找到他们。通常情况下，控件都继承了`Widget`类或是`Control`类，由于SWT是调用JNI实现的，很多基础控件类都是不允许被继承重写的。下面这张图是从[SWT官网](http://www.eclipse.org/swt/widgets/)上截取的图片，你可以预览一下这些基本控件。

**[[images/image_swt_widgets.png]]**

### 1. 控件（Control）的创建和添加

SWT中的控件，除了`Shell`，所有的控件的实例化都要有一个父容器（`Composite`），实例化之后，这个控件就被自动添加到了父容器中，这点和`swing`不太一样，不需要单独的`add()`方法。除此之外，实例化的时候还有一个`int`类型的`style`值，这个`style`值一般都在`org.eclipse.swt.SWT`类中定义，是用来指定一个控件的不同的外表和风格，通常在控件类的`javadoc`中会注明该控件所有可能的风格，默认情况也可以用`SWT.NONE`来代替。

比如：

    new Button(parent, SWT.NONE); //按钮
    new Button(parent, SWT.PUSH); //按钮，同上
    new Button(parent, SWT.CHECK); //复选框
    new Button(parent, SWT.RADIO|SWT.BORDER); //单选框

注：容器类常用的有两个Composite和Group，Group是一个可以设置抬头标题的容器。其它的一些都是从Composite中衍生而来的。

### 2. 控件的事件（Event）处理

SWT中所有的控件都可以添加事件监听，比如鼠标点击，键盘按下等等。而添加的方法也很简单，比如我想添加对按钮的选择事件，可以用以下代码：

       Button button = new Button(shell, SWT.NONE);
       //方法一
       button.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				//TODO: add your codes here
			}
		});
		//方法二
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO add your codes here
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO add your codes here
				
			}
		});
		//方法三
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				//add your codes here
			}
		});

上述代码中的三种添加事件的方法，你如果仔细研究一下代码，其实是一样的。`SelectionAdapter`类是`SelectionListener`接口的一个空的实现而已。而`addSelectionListener()`方法里面本身就是调用`addListener(int eventType, Listener)`来实现的。

### 3. 容器（Composite）的布局（Layout）管理

和`swing`类似，`SWT`也提供了一些标准的布局管理器。默认情况下，`layout`为空，也就是说`Composite`中的每一个元素都要手动的给设置位置和大小，否则默认的位置和大小都为空，则显示不出来。

  * `FillLayout`: 所有的控件都会从水平或垂直方向挤占空间，并且平均分配大小。
  * `RowLayout`: 所有的控件自动排列到一行或一列。
  * `GridLayout`: 所有的控件一次放在格子里。
  * `FormLayout`: 所有的控件根据设置的相关性来排列，设置较为复杂。

更多内容请看[Layouts Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Layouts-Tutorial)

***

上一篇：[SWT](https://github.com/ecsoya/eclipse.tutorial/wiki/Standard-Widget-Toolkit-(SWT))
下一篇：[Label Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Label-Tutorial)
