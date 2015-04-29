package org.ecsoya.eclipse.tutorial.swt.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ImageTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Image Tutorail");
		Image image = new Image(display, 300, 200);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
		gc.drawRectangle(44, 28, 200, 100);
		gc.fillRectangle(45, 29, 199, 99);
		gc.drawString("Hello SWT", 120, 68);
		gc.dispose();

		shell.setBackgroundImage(image);
		shell.setSize(300, 200);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		image.dispose();
		display.dispose();
	}

}
