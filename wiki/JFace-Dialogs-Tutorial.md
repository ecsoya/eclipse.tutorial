---
layout: page
title: JFace Dialogs Tutorial
wikiPageName: JFace-Dialogs-Tutorial
menu: wiki
---

JFace Dialog和[SWT Dialog](http://ecsoya.github.io/eclipse.tutorial/wiki/Dialog-Tutorial)不同，SWT Dialog主要是一些调用系统已有的对话框，比如颜色，字体等，而JFace Dialog主要是提供了一些便于用户自定义的接口，以便我们实现自己的对话框。

### JFace Dialog

我们常用的JFace Dialog主要有一下一些：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_dialogs.png)

#### InputDialog

	InputDialog inputDialog = new InputDialog(shell, "Input Dialog Tutorial", "Input value", "Hello World", null);
	inputDialog.open();

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_inputdialog.png)

#### MessageDialog

	MessageDialog.openConfirm(shell, "Confirm", "Please confirm");
	MessageDialog.openError(shell, "Error", "Error occured");
 	MessageDialog.openInformation(shell, "Info", "Info for you");
 	MessageDialog.openQuestion(shell, "Question", "Really, really?");
 	MessageDialog.openWarning(shell, "Warning", "I am warning you!");
 
示例：

	MessageDialog dialog = new MessageDialog(shell, "My Title", null, "My message", MessageDialog.ERROR, new String[] { "First", "Second", "Third" }, 0);
	int result = dialog.open();
	System.out.println(result);

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_messagedialog.png)

#### TitleAreaDialog

	TitleAreaDialog dialog = new TitleAreaDialog(shell) {
  		protected void configureShell(Shell newShell) {
  			super.configureShell(newShell);
  			newShell.setText("TitleAreaDialog Tutorial");
		}
  		protected Control createDialogArea(Composite parent) {
    		Composite dialogArea = (Composite) super.createDialogArea(parent);
   			// add your contents here
    		setTitle("Add yout TITLE here");
    		setMessage("Add your MESSAGE here");
    	return dialogArea;
  		}
	};
	dialog.open();

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_titleareadialogdialog.png)


#### WizardDialog

	WizardDialog dialog = new WizardDialog(shell, new MyWizard());
	dialog.open();

Wizard：

	public class MyWizard extends Wizard {
  		public MyWizard() {
    		setWindowTitle("Wizard Dialog Tutorial");
  		}
  		public void addPages() {
    		addPage(new WizardPage1());
  		}
  		public boolean performFinish() {
    		return false;
  		}
	}

WizardPage：

	public class WizardPage1 extends WizardPage {
  		protected WizardPage1() {
    		super("WizardPage1");	
  		}
  		public void createControl(Composite parent) {
  			Label control = new Label(parent, SWT.NONE);
    		control.setText("Page1");
    		setControl(control);
    		setTitle("Page1 Title");
    		setMessage("Page1 Message");
  		}
	}

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_jface_wizarddialog.png)


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[TreeViewer Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/TreeViewer-Tutorial) 下一篇：[JFace DataBinding Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-DataBinding-Tutorial)