---
layout: page
title: Action and Menus Tutorial
wikiPageName: Action-and-Menus-Tutorial
menu: wiki
---

在eclipse中几乎所有的ToolBar和MenuBar都能被扩展，通常我们用到的有以下一些：

* 主菜单
* 工具栏
* 视图菜单
* 视图工具栏
* 右键菜单

> 你可能会问，为什么视图的菜单和工具栏能扩展，为什么不能扩展编辑器的呢？
> 其实编辑器是共享eclipse主菜单和工具栏的，具体的实现方法可以参考editor的contributorClass定义以及IEditorActionBarContributor。 

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_actions_overview.jpg)

而所有的这些扩展都是通过实现扩展点：`org.eclipse.ui.menus` 来实现的。

### 第一步：在哪插入？

我们想要扩展Menu或者ToolBar，首先第一步就是定义在哪插入我们的Menu或是ToolBar。

首先，在`org.eclipse.ui.menus`中定义一个`menuContribution`。
你会发现里面有一个`locationURI`的属性，这个属性就是用来定义你的Action的具体的插入位置。

其次，不同的位置，会有与之对应的定义方法，如：

* 主菜单： *menu:org.eclipse.ui.main.menu*
* 工具栏： *toolbar:org.eclipse.ui.main.toolbar*
* 视图菜单： *menu:org.eclipse.ui.views.ContentOutline*
* 视图工具栏：*toolbar:org.eclipse.ui.views.ContentOutline*
* 右键菜单： *popup:org.eclipse.ui.popup.any*

其实，关于`locationURI`的定义，有着一定的规则：`[Schema]:[id](?[Query])`

* **Schema**: `menu`, `popup` 或者 `toolbar`。
* **Id**: 视图或编辑器的ID，或者是一个已经定义好的菜单的ID。
* **Query**: `<placement>=<id>`

	*  **placement**: `before`, `after` 或者 `endof`。
 	*  **id**: 一个已经定义好的菜单的ID。

### 第二步：怎么定义？

依然是在`menuContribution`中，我们可以简单的将它里面的元素分成两类：

* 一类是分组元素：`menu`，`toolbar`和`separator`；
* 一类是具体的Action的定义元素：`command`，`control`和`dynamic`。

如何使用command来定义菜单？我们可以看一段示例：

	<extension
         point="org.eclipse.ui.menus">
      <menuContribution
            locationURI="menu:org.eclipse.ui.main.menu?after=file">
         <menu
               label="Ecsoya">
            <command
                  commandId="org.eclipse.ui.edit.copy"
                  style="push">
            </command>
            <command
                  commandId="org.eclipse.ui.edit.paste"
                  style="push">
            </command>
            <separator
                  name="edit"
                  visible="true">
            </separator>
            <command
                  commandId="org.eclipse.ui.edit.delete"
                  style="push">
            </command>
         </menu>
      </menuContribution>
    </extension>

如下图，我们通过command定义了一个菜单：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_actions_menubar.png)

关于使用control，我们也可以参考以下示例：

	//Extension Point
    <extension
         point="org.eclipse.ui.menus">
      <menuContribution
            allPopups="false"
            locationURI="toolbar:org.eclipse.ui.main.toolbar?after=additions">
         <toolbar
               id="org.ecsoya.eclipse.tutorial.actions.toolbar">
            <control
                  class="org.ecsoya.eclipse.tutorial.actions.SampleToolBarContribution">
            </control>
         </toolbar>
      </menuContribution>
    </extension>
	
	//Java
    public class SampleToolBarContribution extends WorkbenchWindowControlContribution {
    	public SampleToolBarContribution() {
    	}
    	public SampleToolBarContribution(String id) {
       	 super(id);
    	}
    	protected Control createControl(Composite parent) {
      	  Combo combo = new Combo(parent, SWT.READ_ONLY);
      	  for (int i = 0; i < 5; i++) {
           	 combo.add("Ecsoya sample item " + i);
        	}
        	combo.select(2);
        	return combo;
    	}
    }

如下图，我们通过control定义了一个下拉框工具条：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_actions_toolbar.png)

### 扩展视图菜单/工具栏需要注意的问题

1. 一般情况下，视图的ID可能就是你要找的插入的菜单的ID。
2. 如果某个视图在定义的时候，没有注册菜单的ID，你就无法去扩展。
3. 相应的，如果你自己实现了一个视图，想要让别人来扩展右键菜单的时候，你必须要注册一个全局的菜单：

如下面的示例：

	String id = "org.ecsoya.eclipse.tutorials.editor.OutlineMenu";
	MenuManager manager = new MenuManager(id);
	manager.add(new Action("Ecsoya") {
	});
	manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	Menu menu = manager.createContextMenu(control);
	control.setMenu(menu);

	getSite().registerContextMenu(id, manager, selectionProvider);
 

### 工具类

1. org.eclipse.ui.menus.MenuUtils
2. org.eclipse.ui.IWorkbenchActionConstants

### 忘掉吧！

在很久很久以前，我们是用一下扩展点来实现菜单的工具栏的扩展的

1. org.eclipse.ui.actionSets
2. org.eclipse.ui.viewActions  
3. org.eclipse.ui.editorActions 
4. org.eclipse.ui.popupMenus - viewerContribution 
5. org.eclipse.ui.popupMenus - objectContribution

### 你可能需要了解的

1. org.eclipse.ui.commands
2. org.eclipse.ui.handlers
3. org.eclipse.core.expressions.definitions

示例：
>
>     //定义command
>     <extension point="org.eclipse.ui.commands">
>        <command 
>	    defaultHandler="org.ecsoya.eclipse.tutorial.actions.SampleHandler"
>	    id="org.ecsoya.eclipse.tutorial.actions.command"
>	    name="Sample Handler">
>        </command>
>     </extension>
>    //定义执行command的具体的handler
>    <extension point="org.eclipse.ui.handlers">
>        <handler 
>            class="org.ecsoya.eclipse.tutorial.actions.SampleHandler"
>            commandId="org.ecsoya.eclipse.tutorial.actions.command"
>        </handler>
>    </extension>
>
