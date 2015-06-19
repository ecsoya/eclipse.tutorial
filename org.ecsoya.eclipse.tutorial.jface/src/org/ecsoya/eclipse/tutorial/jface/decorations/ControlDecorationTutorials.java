package org.ecsoya.eclipse.tutorial.jface.decorations;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ControlDecorationTutorials {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setText("Decoration Tutorial");
		shell.setSize(300, 200);

		shell.setLayout(new GridLayout(2, false));
		Label label = new Label(shell, SWT.NONE);
		label.setText("Decoration:");

		Image taskImage = new Image(display,
				ControlDecorationTutorials.class
						.getResourceAsStream("task.gif"));
		ControlDecoration labelDec = new ControlDecoration(label, SWT.LEFT
				| SWT.CENTER);
		labelDec.setImage(FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED)
				.getImage());

		Text text = new Text(shell, SWT.BORDER);
		Image helpImage = new Image(display,
				ControlDecorationTutorials.class
						.getResourceAsStream("help.gif"));
		ControlDecoration textDec = new ControlDecoration(text, SWT.RIGHT
				| SWT.TOP);
		textDec.setImage(helpImage);
		textDec.setShowHover(true);
		textDec.setDescriptionText("Decoration text for Text control.");
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		taskImage.dispose();
		display.dispose();
	}
}
