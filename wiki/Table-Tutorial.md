---
layout: page
title: Table Tutorial
wikiPageName: Table-Tutorial
menu: wiki
---

`Table`是一个很常见的组件，`eclipse`的很多`视图（View）`中都有`Table`的身影，比如`Problems`，`Error Log`等等。在`SWT`中`Table`是通过`org.eclipse.swt.widgets.Table`，`org.eclipse.swt.widgets.TableItem`以及`org.eclipse.swt.widgets.TableColumn`来实现的。

我们先来上一张图看看：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table.png)

### 怎么创建Table？接下来我们就一步一步去创建一个Table出来。

_**第一步. 初始化**_：

        Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Table Tutorial");
		shell.setSize(400, 200);

		GridLayout layout = new GridLayout(2, true);
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 0;
		shell.setLayout(layout);

		new Label(shell, SWT.NONE).setText("Table with default style");
		new Label(shell, SWT.NONE).setText("Table with SWT.CHECK style");

		// Table with default style
		Table table1 = new Table(shell, SWT.BORDER);
		table1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Table with SWT.CHECK style
		Table table2 = new Table(shell, SWT.CHECK | SWT.BORDER);
		table2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

如上代码，我们创建了两个Table，一个是默认的，一个是实现了SWT.CHECK的，看图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table2.png)

咦？怎么什么都没有，空白的！是的，我们还没有给他们添加东西呢。

_**第二步. 添加Table里面的内容（TableItem）**_：

给table1添加5行：
    
        // Add 5 table items.
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table1, SWT.CENTER);
			item.setText("default-item " + i);
		}

给table2添加5行

        // Add 5 table items.
		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table2, SWT.CENTER);
			item.setText("check-item " + i);
		}

再来看一看：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table3.png)

怎么样？有东西了吧？

嗯，我知道了原来SWT.CHECK是给每一行前面加了一个可选框啊！

但是，好像还缺点啥啊！Table是不是应该加个表头什么的啊？

嘿嘿，行，就给他设置个表头吧。

_**第三步.设置表头（TableColumn）**_

给table1添加一列：

		// Add table column
		TableColumn nameColumn = new TableColumn(table1, SWT.CENTER);
		nameColumn.setText("Name");

给table2也添加一列：

		// Add table column
		TableColumn optionColumn = new TableColumn(table2, SWT.CENTER);
		optionColumn.setText("Option");

看看效果如何？

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table4.png)

噢噢，怎么回事？怎么又成小白了？

哈哈，别着急，我来告诉你为什么！

TableColumn在初始化的时候，将自己的宽度设为0了，其实，现在Table里面不是没有东西，而是被隐藏了。我们需要给TableColumn设置一个足够大的宽度就可以了。

试试把下面2句加进去吧：

		nameColumn.setWidth(50);

		optionColumn.setWidth(50);

这下怎么样？

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table5.png)

出来了吧？

内容是出来了，可是我们添加的表头呢？还是没有显示啊？

哦，忘了告诉你了，Table在默认情况下是不显示表头的，我们还需要加一行代码：

		// Make herder visible
		table1.setHeaderVisible(true);

		// Make herder visible
		table2.setHeaderVisible(true);

图呢？

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table6.png)

终于搞定了！

不过好单调啊，能不能加点图片什么的装饰一下？

当然可以了！

_**第四步.设置图片**_

    tableItem.setImage(image);
    tableColumn.setImage(image);

此处只是写出了方法，并没有具体的代码示例，效果可以如下图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_swt_table7.png)

至此，两个简单的Table就算完成了。有没有问题？

没有？

那么好，我有几个问题：

1. `如何让Table显示成单元格？`
2. `能不能添加多个TableColumn？如果能，TableItem又怎么设置？`
3. `TableColumn能不能移动？改变位置？`
4. `TableColumn能不能缩放？改变宽度？`
5. `能不能点击TableColumn实现排序？` 

这些问题其实都很简单，多看看Javadoc或是参考资料中的示例就能找到答案。

***
### SWT.VIRTUAL

可能有人会想到，如果要往Table里面添加比较大的数据量时该怎么办？一项一项添加，会不会影响Table的性能？当添加数以万计的数据的时候，table需要多久才能响应到界面上？虽然现在机器的性能都比较强悍，但是在这个数据量爆棚，处处弥漫着大数据的时代，一切皆有可能。
SWT引入了一个参数SWT.VIRTUAL，它是在初始化Table的时候应用的，它能很好的解决大数据的问题，它的核心理念是，每一次Table只加载界面上可能显示的条目，固然你的数据量很大，但你的显示屏总是有限的吧，但你拉动滚动条进行刷新的时候，根据需要再去动态的显示余下的部分。

好了，把大象装冰箱，总共分三步：

1. 初始化Table。

        Table table = new Table(parent, SWT.VIRTUAL);

2. 设置数据总数。
 
        table.setItemCount(1000000000);

3. 动态加载
    
        table.addListener (SWT.SetData, new Listener () {
            public void handleEvent (Event event) {
                TableItem item = (TableItem) event.item;
                int index = table.indexOf (item);
                item.setText ("Item " + index);
                System.out.println (item.getText ());
            }
        }); 

***
### 其它参数介绍

1. `SWT.SINGLE和SWT.MULTI：Table是支持单选还是支持多选。`

2. `SWT.FULL_SELECTION：当设置了这个style之后，选择Table的一行时，会选择这个行的所有列，默认情况下会只选择第一个单元格，即第一列。`

3. `SWT.HIDE_SELECTION：当设置了这个style之后，如果Table失去焦点（focusLost）之后，当前选择的行将不再高亮显示，直到Table再次得到焦点（focusGained）。默认情况是无论Table是否失去焦点，当前选择的行都会高亮显示。`

4. `SWT.NO_SCROLL：很简单，不要滚动条。默认情况下，Table的水平和垂直的滚动条都会显示。`

***
### 事件监听

**1.** _**Selection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.Selection, Listener)来添加。`

_触发条件_:
  
  * `当table的某一行被选中时，立即触发。`
  * `当checkbox被选中时触发，为了与普通的选择区分，event.detail的值等于SWT.CHECK。`


**2.** _**DefaultSelection**_：`通过addSelectionListener(SelectionListener)或addListener(SWT.DefaultSelection, Listener)来添加。`

_触发条件_: 当某一行被双击选择时触发。

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Table Events Tutorial");
		shell.setSize(400, 400);

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		final Text label = new Text(shell, SWT.V_SCROLL | SWT.WRAP);

		final Table table = new Table(shell, SWT.BORDER | SWT.CHECK
				| SWT.FULL_SELECTION);

		Image taskImage = new Image(display,
				TableEventsTutorial.class.getResourceAsStream("task.gif"));

		TableColumn nameColumn = new TableColumn(table, SWT.CENTER);
		nameColumn.setText("Name");
		nameColumn.setWidth(180);
		nameColumn.setImage(taskImage);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Image helpImage = new Image(display,
				TableEventsTutorial.class.getResourceAsStream("help.gif"));

		TableColumn optionColumn = new TableColumn(table, SWT.CENTER);
		optionColumn.setText("Option");
		optionColumn.setWidth(180);
		optionColumn.setImage(helpImage);

		for (int i = 0; i < 5; i++) {
			TableItem item = new TableItem(table, SWT.CENTER);
			item.setText(0, "item-name- " + i);
			item.setText(1, "item-option- " + i);
			item.setImage(0, taskImage);
			item.setImage(1, helpImage);
		}

		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String string = e.detail == SWT.CHECK ? " Checked"
						: " Selected";
				label.append("\n" + e.item + string);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				label.append("\nDouble clicked on " + e.item);
			}
		});

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		helpImage.dispose();
		display.dispose();

**3.** _**MeasureItem**_：`通过addListener(SWT.MeasureItem, Listener)来添加。`

**4.** _**EraseItem**_：`通过addListener(SWT.EraseItem, Listener)来添加。`

**5.** _**PaintItem**_：`通过addListener(SWT.PaintItem, Listener)来添加。`

_触发条件_: 由于上面三个事件都是在TableItem的状态发生改变时触发的，比如鼠标移动，Item选择，Table移动等等。并且这三个事件都会反复的调用，所以用的时候要比较小心。我们一般情况下用它们来实现一些特殊功能，或者自己画一些TableItem。

想了解更多的关于自定义Table的相关内容请看[Custom Drawing Table and Tree Items](http://www.eclipse.org/articles/article.php?file=Article-CustomDrawingTableAndTreeItems/index.html)

***
参考资料：
  * [Table, TableItem, TableColumn snippets](http://www.eclipse.org/swt/snippets/#table)
  * 如果想了解更多的关于设置颜色，字体等其它属性的相关内容，请移步至[控件的通用设置]({{site.baseurl}}/eclipse.tutorial/wiki/Common-Properties-Tutorial.html)
  * 如果想了解更多的关于`Layout`和`LayoutData`的相关内容，请移步至[布局管理器]({{site.baseurl}}/eclipse.tutorial/wiki/Layouts-Tutorial.html)
  * [SWT Example: ControlExample](http://www.eclipse.org/swt/examples.php)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[DateTime Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/DateTime-Tutorial.html)
下一篇：[Tree Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/Tree-Tutorial.html)
