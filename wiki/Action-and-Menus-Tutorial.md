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

- **Schema**: `menu`, `popup` 或者 `toolbar`。
- **Id**: 视图或编辑器的ID，或者是一个已经定义好的菜单的ID。
- **Query**: `<placement>=<id>`
 * **placement**: `before`, `after` 或者 `endof`。
 * **id**: 一个已经定义好的菜单的ID。

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

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_actions_menubar.jpg)

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

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_actions_toolbar.jpg)

