---
layout: page
title: Dialog Tutorial
wikiPageName: Dialog-Tutorial
menu: wiki
---

对话框`（Dialog）`是我们经常用到的一个组件，其实它跟`Shell`很类似，在这里只讲几个经常用到的系统对话框，至于怎么自己实现对话框，请参考后面的文章[JFace Dialogs]({{site.baseurl}}/wiki/JFace-Dialogs-Tutorial.html)

### 1. ColorDialog

`org.eclipse.swt.widgets.ColorDialog`

    ColorDialog dialog = new ColorDialog(shell);
    dialog.setRGB(oldValue); //设置颜色。
    RGB newValue = dialog.open(); //当选好颜色点击OK关闭时返回新的颜色，否则返回空值。

如图：

![]({{site.baseurl}}/wiki/images/image_swt_dialog_color.png)


### 2. DirectoryDialog

`org.eclipse.swt.widgets.DirectoryDialog`

		DirectoryDialog dialog = new DirectoryDialog(shell);
		dialog.setText("Foxes vs. Dogs"); // 设置对话框的标题。
		dialog.setMessage("A qiuick brown fox jumps over the laze dog."); // 设置提示信息。
		dialog.setFilterPath("C:"); // 设置找寻文件夹的初始目录。
		String open = dialog.open(); // 返回选取的文件夹，如果取消，则返回空。

如图：

![]({{site.baseurl}}/wiki/images/image_swt_dialog_directory.png)


### 3. FileDialog

`org.eclipse.swt.widgets.FileDialog`分为两种，一是打开文件对话框，而是保存文件对话框。

		FileDialog openDialog = new FileDialog(shell, SWT.OPEN | SWT.MULTI); //SWT.MULTI允许打开多个文件。
		openDialog.setText("Open File Dialog"); //设置对话框的标题。
		openDialog.setFilterExtensions(new String[] { "*.jpg;*.png;*.gif",
				"*.*" }); //设置打开文件的后缀名
		openDialog.setFilterPath("C:"); //设置要打开文件的初始目录。
		String open = openDialog.open(); //返回打开的文件的绝对路径。

		FileDialog saveDialog = new FileDialog(shell, SWT.SAVE);
		saveDialog.setText("Save File Dialog");
		saveDialog.setFilterExtensions(new String[] { "*.txt" });
		saveDialog.setFileName("new_file"); //设置要保存的文件的名称，可以为空。
		saveDialog.setFilterPath("C:"); 
 		saveDialog.setOverwrite(true); //设置文件存在需要覆盖时，要不要弹出询问窗口，true为弹出，false为默认覆盖。
		saveDialog.open();


### 4. FontDialog

`org.eclipse.swt.widgets.FontDialog`

		FontDialog dialog = new FontDialog(shell);
		dialog.setEffectsVisible(true);
		FontData open = dialog.open();

如图：

![]({{site.baseurl}}/wiki/images/image_swt_dialog_font.png)


### 5. PrintDialog

`org.eclipse.swt.printing.PrintDialog`

		PrintDialog dialog = new PrintDialog(shell);
		dialog.setStartPage(1);
		dialog.setEndPage(3);
		dialog.setPrintToFile(true);
		dialog.open();

![]({{site.baseurl}}/wiki/images/image_swt_dialog_print.png)

### 6. MessageBox

`org.eclipse.swt.widgets.MessageBox`

		MessageBox box = new MessageBox(shell, SWT.RETRY | SWT.IGNORE
				| SWT.ABORT | SWT.ICON_QUESTION); // 设置按钮和图标。
		box.setText("Foxes vs. Dogs"); // 设置标题。
		box.setMessage("A quick brown fox jumps over the lazy dog?"); //设置信息。
		int result = box.open();

如图:

![]({{site.baseurl}}/wiki/images/image_swt_dialog_messagebox.png)

***
参考资料：
  * [Printing snippets](http://www.eclipse.org/swt/snippets/#printing)
  * [Sample code and further information](http://www.eclipse.org/swt/)

***

上一篇：[Browser Tutorial]({{site.baseurl}}/wiki/Browser-Tutorial.html)
下一篇：[Common Properties Tutorial]({{site.baseurl}}/wiki/Common-Properties-Tutorial.html)
