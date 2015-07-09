package org.ecsoya.eclipse.tutorial.swt.viewform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ViewFormTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("ViewForm Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new FillLayout());

		ViewForm form = new ViewForm(shell, SWT.FLAT);
		Label content = new Label(form, SWT.BORDER);
		content.setText("Content of ViewForm");
		content.setAlignment(SWT.CENTER);
		form.setContent(content);

		Label topLeft = new Label(form, SWT.BORDER);
		topLeft.setText("TopLeft");
		form.setTopLeft(topLeft);

		Label topCenter = new Label(form, SWT.BORDER);
		topCenter.setText("TopCenter");
		form.setTopCenter(topCenter);

		Label topRight = new Label(form, SWT.BORDER);
		topRight.setText("TopRight");
		form.setTopRight(topRight);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
