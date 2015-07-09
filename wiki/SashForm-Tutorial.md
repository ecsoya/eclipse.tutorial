---
layout: page
title: SashForm Tutorial
wikiPageName: SashForm-Tutorial
menu: wiki
---

SashForm是一个Composite，它整合了[Sash](http://ecsoya.github.io/eclipse.tutorial/wiki/Sash-Tutorial)的功能，让我们使用Sash的时候不再复杂。

	final Display display = new Display ();
	Shell shell = new Shell(display);
	shell.setLayout (new FillLayout());

	SashForm form = new SashForm(shell,SWT.HORIZONTAL);
	form.setLayout(new FillLayout());
	
	Composite child1 = new Composite(form,SWT.NONE);
	child1.setLayout(new FillLayout());
	new Label(child1,SWT.NONE).setText("Label in pane 1");
	
	Composite child2 = new Composite(form,SWT.NONE);
	child2.setLayout(new FillLayout());
	new Button(child2,SWT.PUSH).setText("Button in pane2");

	Composite child3 = new Composite(form,SWT.NONE);
	child3.setLayout(new FillLayout());
	new Label(child3,SWT.PUSH).setText("Label in pane3");
	
	form.setWeights(new int[] {30,40,30});
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();

> 
>SashForm一定要记得调用setWeight方法设置每一个组件所占的比例。
>

### 参考资料
1. [SashForm snippets](http://www.eclipse.org/swt/snippets/#sashform)
2. [SWT Example: CustomControlExample](http://www.eclipse.org/swt/examples.php)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[CTabFolder Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/CTabFolder-Tutorial)  下一篇：[CLabel Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/CLabel-Tutorial)
