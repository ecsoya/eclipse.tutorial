package org.ecsoya.eclipse.tutorial.swt.tooltip;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;

public class ToolTipTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		shell.setText("ToolTip Tutorial");
		shell.setSize(450, 200);

		shell.setLayout(new GridLayout());

		// 1. Add tooltip for Shell.
		shell.setToolTipText("ToolTip Tutorial: this is a simple tooltip text for Shell.");

		// 2. Create a normal tooltip Widget.
		final ToolTip tip = new ToolTip(shell, SWT.NONE);
		tip.setText("Foxes vs. Dogs");
		tip.setMessage("The quick brown fox jumps over the lazy dog.");
		tip.setAutoHide(false);
		final Button showTipButton = new Button(shell, SWT.NONE);
		showTipButton.setText("Show ToolTip");
		showTipButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (tip.isVisible() || tip.isDisposed()) {
					return;
				}
				Rectangle r = showTipButton.getBounds();
				Point pt = showTipButton.toDisplay(r.x + r.width + 50, r.y);
				tip.setLocation(pt);
				tip.setVisible(true);
			}
		});

		// 3. Create a tooltip Widget which looks like a balloon.
		final ToolTip balloon = new ToolTip(shell, SWT.BALLOON
				| SWT.ICON_INFORMATION);
		balloon.setText("Foxes vs. Dogs");
		balloon.setMessage("The quick brown fox jumps over the lazy dog.");
		balloon.setAutoHide(true);

		final Button showTipButton2 = new Button(shell, SWT.NONE);
		showTipButton2.setText("Show Balloon ToolTip");
		showTipButton2.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (balloon.isVisible() || balloon.isDisposed()) {
					return;
				}
				Rectangle r = showTipButton2.getBounds();
				Point pt = showTipButton2.toDisplay(r.x + r.width, r.y);
				balloon.setLocation(pt);
				balloon.setVisible(true);
			}
		});

		Button closeTipButton = new Button(shell, SWT.NONE);
		closeTipButton.setText("Close");
		closeTipButton.setToolTipText("Close all tooltips.");
		closeTipButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (!balloon.isDisposed()) {
					balloon.setVisible(false);
				}
				if (!tip.isDisposed()) {
					tip.setVisible(false);
				}
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
