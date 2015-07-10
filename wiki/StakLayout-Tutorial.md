---
layout: page
title: StakLayout Tutorial
wikiPageName: StakLayout-Tutorial
menu: wiki
---

StackLayout是一个特殊的Layout，容器中所有的控件的位置和大小都是一致的，而且当前只能显示一个控件。要显示的控件用**topControl**来改变。

 	public static void main(String[] args) {
 		Display display = new Display();
 		Shell shell = new Shell(display);
 		shell.setLayout(new GridLayout());
 	
 		final Composite parent = new Composite(shell, SWT.NONE);
 		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
 		final StackLayout layout = new StackLayout();
 		parent.setLayout(layout);
 		final Button[] bArray = new Button[10];
 		for (int i = 0; i < 10; i++) {
 			bArray[i] = new Button(parent, SWT.PUSH);
 			bArray[i].setText("Button "+i);
 		}
 		layout.topControl = bArray[0];
 	
 		Button b = new Button(shell, SWT.PUSH);
 		b.setText("Show Next Button");
 		final int[] index = new int[1];
 		b.addListener(SWT.Selection, new Listener(){
 			public void handleEvent(Event e) {
 				index[0] = (index[0] + 1) % 10;
 				layout.topControl = bArray[index[0]];
 				parent.layout();
 			}
 		});
 	
 		shell.open();
 		while (shell != null && !shell.isDisposed()) {
 			if (!display.readAndDispatch())
 				display.sleep(); 
 		} 	
 	}

### 参考资料
1. [StackLayout snippets](http://www.eclipse.org/swt/snippets/#stacklayout)
2. [SWT Example: LayoutExample](http://www.eclipse.org/swt/examples.php)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[FormLayout Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/FormLayout-Tutorial) 下一篇：[Resource Management Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Resource-Management-Tutorial)
