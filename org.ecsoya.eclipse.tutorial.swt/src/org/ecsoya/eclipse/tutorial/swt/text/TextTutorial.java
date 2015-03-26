package org.ecsoya.eclipse.tutorial.swt.text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Text Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		Text text1 = new Text(shell, SWT.NONE);
		text1.setText("Default Text");

		Text text2 = new Text(shell, SWT.BORDER);
		text2.setText("Text with border");

		Text text3 = new Text(shell, SWT.MULTI |SWT.BORDER);
		text3.setText("Text with multi lines\nAuto wrapped.");
		
		Text text4 = new Text(shell, SWT.PASSWORD |SWT.BORDER);
		text4.setText("123456");
		
		Text text5 = new Text(shell, SWT.READ_ONLY | SWT.BORDER);
		text5.setText("Read only Text");
		
		Text text6 = new Text(shell, SWT.SEARCH | SWT.BORDER);
		text6.setText("Search Text");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
