---
layout: page
title: GridLayout Tutorial
wikiPageName: GridLayout-Tutorial
menu: wiki
---

GridLayout是SWT中使用率最高的一个Layout，它主要采用的是格子式布局。

### GridLayout

1. **Columns**
	* **numColumns**：将容器分成几列。
	* **makeColumnEqualsWidth**：要不要将每一列的宽度设为一样的。
2. **Margins**
	* **marginWidth**：水平方向左右两边的留白。
	* **marginHeight**：垂直方向上下两边的留白。
	* **marginTop**：上边的留白。
	* **marginLeft**：左边的留白。
	* **marginRight**：右边的留白。
	* **marginBottom**：底下的留白。
3. **Spacings**
	* **horizontalSpacing**：水平方向两列之间的距离。
	* **verticalSpacing**：垂直方向两行之间的距离。



		    GridLayout layout = new GridLayout();
    		layout.numColumns = 2; 
    		layout.makeColumnsEqualWidth= true;
    		layout.marginHeight = 5;
    		layout.marginWidth = 5;
    		layout.horizontalSpacing = 0;
    		layout.verticalSpacing = 0;
    

### GridData
1. **Alignment**：对齐方式，**horizontalAlignment和verticalAlignment**。
	* **SWT.FILL**：填充对齐。
	* **SWT.CENTER**：居中对齐。
	* **SWT.BEGINNING**：左（上）对齐。
	* **SWT.END**：右（下）对齐。
2. **Indentation**：缩进。
	* **horizontalIndent**：距做边界的缩进值。
	* **verticalIndent**：距上边界的缩进值。
3. **Grab extra space**：抢占额外的空间，单元格的大小会随着父容器的大小而改变。
	* **grabExcessHorizontalSpace**：抢占水平方向上的额外空间。
	* **grabExcessVerticalSpace**：抢占垂直方向上的额外空间。
4. **Span**：所占单元格的数量。
	* **horizontalSpan**：控件占几列？默认为1。
	* **verticalSpan**：控件占几行？默认为1。
5. **Minimum size**：最小值，当且仅当Grab extra space的值为true时有用。
	* **minimumWidth**：*grabExcessHorizontalSpace=true*时有用。
	* **minimumHeight**：*grabExcessVerticalSpace=true*时有用。
6. **Exclude**：控件被Layout忽略与否。


    	GridData data = new GridData();
    	data.grabExcessHorizontalSpace = true; // grab extra horizontal space
    	data.horizontalAlignment = GridData.FILL; // BEGINNING, CENTER, END and FILL
    	data.horizontalSpan = 2; // 2 columns
    	data.horizontalIndent = 1; // from left side 1 pixels
    

### 参考资料
1. [GridLayout snippets](http://www.eclipse.org/swt/snippets/#gridlayout)
2. [SWT Example: LayoutExample](http://www.eclipse.org/swt/examples.php)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[RowLayout Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/RowLayout-Tutorial.html) 下一篇：[FormLayout Tutorial]({{site.baseurl}}/eclipse.tutorial/wiki/FormLayout-Tutorial.html)