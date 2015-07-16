---
layout: page
title: Editors Tutorial
wikiPageName: Editors-Tutorial
menu: wiki
---

编辑器（Editor）是也是一个比较常用的组件，常见的如JavaEditor，XMLEditor等支持文本的编辑，并且有不同的颜色标记。

Editor的实现是通过`org.eclipse.ui.editors`扩展点来实现的。

### editor
1. **id**: 唯一的标识。
2. **name**: 显示的名称。
3. **icon**: 显示的图标。
4. **extensions**: 设置能编辑的文件的扩展名，多个可用逗号（，）隔开。  
5. **class**: 实现*org.eclipse.ui.IEditorPart*接口或是继承*org.eclipse.ui.EditorPart*类。 
6. **contributorClass**: 实现*org.eclipse.ui.IEditorActionBarContributor*接口，扩展编辑器相关的Action（菜单，工具栏等）。 
7. **matchingStrategy**: 实现*org.eclipse.ui.IEditorMatchingStrategy*接口，定义打开编辑器的策略，同一个文件可以用不同的编辑器打开编辑。
8. **command**: 打开外部编辑器命令。
9. **launcher**: 定义一个打开编辑器的命令类，实现*org.eclipse.ui.IEditorLauncher*接口、 
10. **default**: 设置是不是某种类型文件的默认编辑器，可以通过双击文件直接打开。
11. **filenames**: 设置打开具体的某种命名的文件。
12. **symbolicFontName**: 字体名称，详见*org.eclipse.ui.fontDefinitions*扩展点。这个常用在扩展文本编辑器（TextEditor）中，用来标识文本编辑器的默认字体。

### IEditorPart, EditorPart

	public class SampleEditor extends EditorPart {
    	public SampleEditor() {
    	}
	    public void doSave(IProgressMonitor monitor) {
	    }
	    public void doSaveAs() {
	    }
	    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
	    }
	    public boolean isDirty() {
	        return false;
	    }
	    public boolean isSaveAsAllowed() {
	        return false;
	    }
	    public void createPartControl(Composite parent) {
	    }
	    public void setFocus() {
	    }
	}

#### 初始化
这个方法主要用来验证编辑器的输入（编辑器的输入指的是编辑器打开的某种文件，或者某个数据，通常封装在IEditorInput中）是否正确。

	public void init(IEditorSite site, IEditorInput input) throws  PartInitException {
 	 	if (!(input instanceof IFileEditorInput)) {
  	  	 	throw new PartInitException("Invalid Input: Must be IFileEditorInput");
  		}
 	 setSite(site);
 	 setInput(input);
	}

#### 创建内容
创建编辑器的内容。

	public void createPartControl(Composite parent) {
  		control = new Composite(parent, SWT.NONE);
  		// create editor control here
	}

	public void setFocus() {
  		control.setFocus();
	}
 
#### 保存

	public void doSave(IProgressMonitor monitor) {
	}

	public void doSaveAs() {
	}

	public boolean isDirty() {
	    return false;
	}

	public boolean isSaveAsAllowed() {
	    return false;
	}

保存之前，通常会调用isDirty()方法来验证是不是需要保存，保存之后一定要在editor中调用如下方法来刷新状态。

	firePropertyChange(PROP_DIRTY);


#### 标题

	setPartName("Ecsoya - Sample editor");
	setTitleToolTip("Welcome to soyatec!");

更改之后，刷新的方法。

	firePropertyChange(IWorkbenchPart.PROP_TITLE);

### IEditorActionBarContributor

扩展编辑器的Action，包括工具栏，系统菜单，状态栏等。

	public class SampleEditorActionBarContributor extends EditorActionBarContributor {
    	public void contributeToCoolBar(ICoolBarManager coolBarManager) {
    	    super.contributeToCoolBar(coolBarManager);
    	}

    	public void contributeToMenu(IMenuManager menuManager) {
    	    super.contributeToMenu(menuManager);
    	}

    	public void contributeToToolBar(IToolBarManager toolBarManager) {
    	    super.contributeToToolBar(toolBarManager);
    	}

    	public void contributeToStatusLine(IStatusLineManager statusLineManager) {
    	    super.contributeToStatusLine(statusLineManager);
    	}
	} 

### 打开编辑器

	// Workbench instance from our plugin instance.
	IWorkbench workbench = Activator.getDefault().getWorkbench();
	// Active window instance.
	IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
	// Active page instance.
	IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
	try {
    	SampleEditorInput editorInput = new SampleEditorInput();
    	// Open editor from the editor input and editor ID.
    	activePage.openEditor(editorInput, SampleEditor.ID); // defined from extension.
	} catch (PartInitException e) {
    	e.printStackTrace();
	}

### 多页编辑器

	public class SampleMultiPageEditor extends MultiPageEditorPart {

    	protected void createPages() {
      	  	// add other controls or editors here.
       		addPage(control);
        	addPage(editor, input);
    	}

    	public void doSave(IProgressMonitor monitor) {
    	}
    	public void doSaveAs() {
    	}
    	public boolean isSaveAsAllowed() {
	        return false;
    	}
	}

### 编辑器附属视图

在Eclipse中，一些视图会根据当前编辑器的不同显示不同的内容，如大纲视图（Outline），属性视图（Properties）等，这些视图都是通过PageBookView来实现的。

如Outline视图的实现：

首先，实现一个IContentOutlinePage的实例：

	public class SampleContentOutlinePage extends ContentOutlinePage {
   		private Label control;
    	public void createControl(Composite parent) {
        	control = new Label(parent, SWT.NONE);
        	control.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
        	control.setText("Outline for sample editor");
    	}
    	public Control getControl() {
        	return control;
    	}
    	public void setFocus() {
        	control.setFocus();
    	}
	}


其次，在编辑器中的getAdapter()方法中加入以下代码：

	public Object getAdapter(Class adapter) {
	    if (IContentOutlinePage.class == adapter) {
	        return new SampleContentOutlinePage();
	    }
	    return super.getAdapter(adapter);
	}

这样，你的编辑器就拥有了一个自己的Outline视图。

***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Views Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Views-Tutorial) 下一篇：[Action and Menus Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Action-and-Menus-Tutorial)
