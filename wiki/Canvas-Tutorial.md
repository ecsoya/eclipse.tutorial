---
layout: page
title: Canvas Tutorial
wikiPageName: Canvas-Tutorial
menu: wiki
---

虽然所有的Composite都可以添加PaintListener，然后通过paintEvent支持自定义的画图，但SWT还是引入了专门用来画图的类org.eclipse.swt.widgets.Canvas。

请看下面一段示例：

		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("Canvas Tutorial");
		shell.setSize(300, 200);
		shell.setLayout(new FillLayout());

		Canvas canvas = new Canvas(shell, SWT.BORDER);
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.fillRectangle(1, 1, 50, 50);

				gc.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				gc.drawText("Text: Foxes vs. Dogs", 85, 25);

				gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
				gc.drawOval(150, 100, 50, 50);
			}
		});
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如图：

**[[images/image_swt_canvas.png]]**

### Canvas支持的特殊的style。

1. **SWT.NO_BACKGROUND**：不支持背景色，一般情况下，Canvas在绘制的时候会先设置自己的背景色（通过setBackground()方法设置的颜色），然后再调用paintEvent事件的GC去画里面的东西，如果在调用GC去画东西的时候，又设置了新的背景色，则整个Canvas会有一个闪的画面，如果设置了这个属性，Canvas便不再支持通过setBackground()方法设置的背景色。
2. **SWT.NO_REDRAW_RESIZE**：在默认的情况下，当Canvas的大小改变的时候，paint事件将被触发，而整个Canvas界面将被重画，如果设置了这个属性，则只是重画改变了的那部分区域，没有改变的将会忽略，从而节省时间。这个属性对画那些固定了位置和大小的图形的时候比较有效。
3. **SWT.NO_MERGE_PAINTS**：一般情况下，如果控件的很多个区域需要重新绘制的时候（dirty），SWT会将这些区域合并成一个，然后重新绘制一遍即可，如果设置了这个属性，则每一个区域都要重新绘制一遍。

### Graphics

所有的绘制工具都包含在`org.eclipse.swt.graphics`包中，其中，最重要的便是`org.eclipse.swt.graphics.GC`。关于GC的详细信息，请参考[Introduction to SWT Graphics](http://eclipse.org/articles/Article-SWT-graphics/SWT_graphics.html)

***
参考资料：
  * [Canvas snippets](http://www.eclipse.org/swt/snippets/#canvas)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Composite Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Composite-Tutorial)
下一篇：[Group Tutorial](https://github.com/ecsoya/eclipse.tutorial/wiki/Group-Tutorial)
