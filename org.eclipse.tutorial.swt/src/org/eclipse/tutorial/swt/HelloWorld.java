package org.eclipse.tutorial.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloWorld {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setText("Hello World");
		shell.setSize(300, 200);
		shell.open();
		
		while(!shell.isDisposed()){
			if (!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
