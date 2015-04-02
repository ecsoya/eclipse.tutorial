package org.ecsoya.eclipse.tutorial.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserTutorial {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Browser Tutorial");
		shell.setLayout(new FillLayout());
		Browser browser = null;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			/*
			 * The Browser widget throws an SWTError if it fails to instantiate
			 * properly. Application code should catch this SWTError and disable
			 * any feature requiring the Browser widget. Platform requirements
			 * for the SWT Browser widget are available from the SWT FAQ
			 * website.
			 */
		}
		if (browser != null) {
			/* The Browser widget can be used */
			browser.setUrl("http://www.eclipse.org");
		}
		shell.setSize(400, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
