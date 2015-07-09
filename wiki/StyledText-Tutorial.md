---
layout: page
title: StyledText Tutorial
wikiPageName: StyledText-Tutorial
menu: wiki
---

StyledText不同于[Text](http://ecsoya.github.io/eclipse.tutorial/wiki/Text-Tutorial)，它是一个富文本编辑器，可以给选中的文本设置颜色，字体等特殊的样式。

### StyleRange

StyleRange继承了org.eclipse.swt.graphics.TextStyle，是StyledText中用来绘制不同样式的关键，`start`和`length`属性分别代表了当前样式的起始位置和长度。

1. 设置颜色和字体
	
		StyleRange style = new StyleRange();
		style.background = backgroundColor;
		style.foreground = foregroundColor;
		style.borderColor = borderColor;
		style.font = font;
		style.strikeout = true;
		style.underline = false;
		style.underlineColor = underlineColor;
2. 设置图片
	
		void addImage(Image image) {
			int offset = styledText.getCaretOffset();
			styledText.replaceTextRange(offset, 0, "\uFFFC"); //$NON-NLS-1$
			StyleRange style = new StyleRange();
			Rectangle rect = image.getBounds();
			style.metrics = new GlyphMetrics(rect.height, 0, rect.width);
			style.data = image;
			int[] ranges = {offset, 1};
			StyleRange[] styles = {style};
			styledText.setStyleRanges(0,0, ranges, styles);
		}
3. 添加控件

		void addControl(Control control) {
			int offset = styledText.getCaretOffset();
			styledText.replaceTextRange(offset, 0, "\uFFFC"); //$NON-NLS-1$
			StyleRange style = new StyleRange();
			Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			int ascent = 2 * size.y / 3;
			int descent = size.y - ascent;
			style.metrics = new GlyphMetrics(ascent + MARGIN, descent + MARGIN, size.x + 2 	* MARGIN);
			style.data = control;
			int[] ranges = {offset, 1};
			StyleRange[] styles = {style};
			styledText.setStyleRanges(0,0, ranges, styles);
			control.setSize(size);
		}


### 参考资料
1. [StyledText snippets](http://www.eclipse.org/swt/snippets/#styledtext)
2. [SWT Example: CustomControlExample](http://www.eclipse.org/swt/examples.php)

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[ViewForm Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/ViewForm-Tutorial)