package org.ecsoya.eclipse.tutorial.swt.canvas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CanvasTutorial {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("Canvas Tutorial");
		shell.setSize(300, 200);
		shell.setLayout(new FillLayout());

		Canvas canvas = new Canvas(shell, SWT.BORDER);
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.fillRectangle(1, 1, 50, 50);

				gc.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				gc.drawText("Text: Foxes vs. Dogs", 85, 25);

				gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
				gc.drawOval(150, 100, 50, 50);
			}
		});
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
