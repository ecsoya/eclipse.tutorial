package org.ecsoya.eclipse.tutorial.swt.link;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class LinkTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Link Tutorial");

		shell.setLayout(new FillLayout(SWT.VERTICAL));

		Label label = new Label(shell, SWT.WRAP);
		label.setText("Try to click on the hyperlink of the Link\n(with yellow background).");
		Link link = new Link(shell, SWT.NONE);
		link.setText("1. Visit <a href=\"http://www.eclipse.org\">Eclipse</a> website,\n2. Visit <a href=\"http://www.soyatec.com\">Soyatec</a> website.");
		link.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
		final Label result = new Label(shell, SWT.NONE);
		link.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				result.setText(event.text);
			}
		});

		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
