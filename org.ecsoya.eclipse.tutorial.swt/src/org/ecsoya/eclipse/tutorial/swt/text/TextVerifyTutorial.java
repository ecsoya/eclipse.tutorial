package org.ecsoya.eclipse.tutorial.swt.text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextVerifyTutorial {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Text Modify Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout());

		final Text result = new Text(shell, SWT.MULTI | SWT.V_SCROLL);
		result.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		final Text text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				result.setText(result.getText() + "\nText modified to: "
						+ text.getText());
			}
		});
		
		text.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				int start = e.start;
				int end = e.end;
				String newValue = e.text;
				result.setText("Replace [" + start +"-" + end + "] to '" + newValue + "'");
				if ("d".endsWith(newValue)){
					e.doit = false;
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
