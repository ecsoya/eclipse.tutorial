package org.ecsoya.eclipse.tutorial.swt.slider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;

public class SliderTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Slider Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new RowLayout(SWT.VERTICAL));

		Slider vSlider = new Slider(shell, SWT.VERTICAL);
		vSlider.setMaximum(100);
		vSlider.setThumb(20);

		Slider hSlider = new Slider(shell, SWT.HORIZONTAL);
		hSlider.setMaximum(100);
		hSlider.setSelection(50);
		hSlider.setThumb(10);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
