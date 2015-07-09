---
layout: page
title: Drag and Drop Tutorial
wikiPageName: Drag-and-Drop-Tutorial
menu: wiki
---

SWT Dnd 功能主要有三部分组成：

* Transfer
* DragSource
* DropTarget

### Transfer

Transfer主要用来保存和转换在拖拽过程中的数据。

### DragSource

DragSource用来定义拖拽源，它上面会添加一个DragSourceListener的事件监听来完成数据的上传。

	// Enable a label as a Drag Source
	Label label = new Label(shell, SWT.NONE);
	// This example will allow text to be dragged
	Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
	// This example will allow the text to be copied or moved to the drop target
	int operations = DND.DROP_MOVE | DND.DROP_COPY;
	
	DragSource source = new DragSource(label, operations);
	source.setTransfer(types);
	source.addDragListener(new DragSourceListener() {
		public void dragStart(DragSourceEvent e) {
			// Only start the drag if there is actually text in the
			// label - this text will be what is dropped on the target.
			if (label.getText().length() == 0) {
				event.doit = false;
			}
		};
		public void dragSetData(DragSourceEvent event) {
			// A drop has been performed, so provide the data of the 
			// requested type.
			// (Checking the type of the requested data is only 
			// necessary if the drag source supports more than 
			// one data type but is shown here as an example).
			if (TextTransfer.getInstance().isSupportedType(event.dataType)){
				event.data = label.getText();
			}
		}
		public void dragFinished(DragSourceEvent event) {
			// A Move operation has been performed so remove the data
			// from the source
			if (event.detail == DND.DROP_MOVE)
				label.setText("");
		}
	});


### DropTarget

DropTarget用来定义Drop目标，它会通过添加DropTargetListener事件监听将Transfer中的数据下载，并应用到当前控件中。

	int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK;
	Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
	DropTarget target = new DropTarget(label, operations);
	target.setTransfer(types);
 	
	target.addDropListener (new DropTargetListener() {
		public void dragEnter(DropTargetEvent event) {};
		public void dragOver(DropTargetEvent event) {};
		public void dragLeave(DropTargetEvent event) {};
		public void dragOperationChanged(DropTargetEvent event) {};
		public void dropAccept(DropTargetEvent event) {}
		public void drop(DropTargetEvent event) {
			// A drop has occurred, copy over the data
			if (event.data == null) { // no data to copy, indicate failure in event.detail
				event.detail = DND.DROP_NONE;
				return;
			}
			label.setText ((String) event.data); // data copied to label text
		}
 	});

### 参考资料

1. [Drag and Drop snippets](http://www.eclipse.org/swt/snippets/#dnd)
2. [SWT Example: DNDExample](http://www.eclipse.org/swt/examples.php)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[StyledText Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/StyledText-Tutorial) 下一篇：[Layouts Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Layouts-Tutorial)