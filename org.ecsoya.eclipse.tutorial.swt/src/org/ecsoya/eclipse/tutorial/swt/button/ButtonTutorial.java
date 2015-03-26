package org.ecsoya.eclipse.tutorial.swt.button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Button Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(2, true));
		
		//Button
		new Button(shell, SWT.PUSH).setText("Button1");
		new Button(shell, SWT.PUSH).setText("Button2");
		
		//CheckBox
		new Button(shell, SWT.CHECK).setText("CheckBox1");
		Button checkBox = new Button(shell, SWT.CHECK);
		checkBox.setText("CheckBox2");
		checkBox.setSelection(true);
		
		//RadioBox
		new Button(shell, SWT.RADIO).setText("RadioBox1");
		Button radioBox = new Button(shell, SWT.RADIO);
		radioBox.setText("RadioBox2");
		radioBox.setSelection(true);
		
		//Toggle
		new Button(shell, SWT.TOGGLE).setText("Toggle1");
		Button toggle = new Button(shell, SWT.TOGGLE);
		toggle.setText("Toggle2");
		toggle.setSelection(true);
		
		//Arrow
		new Button(shell, SWT.ARROW|SWT.LEFT);
		new Button(shell, SWT.ARROW|SWT.RIGHT);
		new Button(shell, SWT.ARROW|SWT.TOP);
		new Button(shell, SWT.ARROW|SWT.BOTTOM);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
