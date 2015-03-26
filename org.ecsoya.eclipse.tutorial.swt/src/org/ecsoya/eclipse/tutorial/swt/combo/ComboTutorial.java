package org.ecsoya.eclipse.tutorial.swt.combo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ComboTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Combo Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));
		
		Combo dropDown = new Combo(shell, SWT.DROP_DOWN);
		for (int i = 0; i < 5; i++) {
			dropDown.add("drop-down -" + i);
		}
		dropDown.select(2);
		
		Combo simple = new Combo(shell, SWT.SIMPLE);
		for (int i = 0; i < 5; i++) {
			simple.add("simpe-item-" + i);
		}
		simple.select(3);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
