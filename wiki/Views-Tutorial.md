---
layout: page
title: Views Tutorial
wikiPageName: Views-Tutorial
menu: wiki
---

视图（View）是我们在插件开发中用的比较多的一个组件，我们常用的视图有*PackageExplorer*，*Navigator*，*Outline*，*Properties等*。

### org.eclipse.ui.views

扩展视图就要用到这个扩展点`org.eclipse.ui.views`，它里面的主要内容有：

1. **category**：Category是用来将视图进行分组的。
2. **e4View**：定义一个e4风格的视图。
3. **view**：定义一个普通的视图。
4. **stickyView**：定义一个常驻Window的视图，这个视图可以在任何的透视图（Perspective）中都显示，除非用户手动的去关闭。

> 1. e4View和view的定义方法是不一样的，我们通常意义上的视图指的都是Eclipse 3.x版本的视图，实现视图的类必须继承IViewPart的接口。但e4中的视图就不用实现这个接口，只需要在类中添加一些Injection Annotation（如@Inject）就能实现。
> 2. stickyView中其实没有定义真正的视图，它只是引用一个已有的视图去设置一个常驻Window的位置。

### Category

1. **id**：唯一标识，在View中引用的时候就靠它。
2. **name**：显示的名称。
3. **parentCategory**：定义父节点。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugins_view1.png)

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugins_view2.png)

### View

1. **id**：
2. **name**：
3. **class**：实现`org.eclipse.ui.IViewPart`接口，或是继承`org.eclipse.ui.part.ViewPart`类。
4. **category**：分组的Category的id，多个可以用`/`分开。
5. **icon**：
6. **fastViewWidthRatio**：视图宽度和Workbench宽度的比例值，介于0.05到0.95之间。
7. **allowMultiple**：是不是允许多个视图同时存在，默认值是false。
8. **restorable**：是不是允许Workbench启动时自动打开视图，默认是true。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugins_view3.png)


### IViewPart，ViewPart
一般情况下，我们通过继承ViewPart类来实现我们的视图。而`createPartControl()`方法就是我们用来创建视图界面的入口方法。

	public class SampleView extends ViewPart {
  		public void createPartControl(Composite parent) {
  		}
  		public void setFocus() {
  		}
	}


### Contributing Actions
定义好了视图，我们可以给视图添加相应的Action，与视图相关的Action有三类：

1. 上下文菜单（Context Menu）：可以在视图实现类里完成，也可以通过[实现Menu扩展点](http://ecsoya.github.io/eclipse.tutorial/wiki/Action-and-Menus-Tutorial)的方式完成。
2. 视图工具栏（ToolBar）：在视图实现类里完成。
3. 视图菜单（Local Menu）：在视图实现类里完成。

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugins_view4.png)

#### Context Menu

	MenuManager menuMgr = new MenuManager("#PopupMenu");
	menuMgr.setRemoveAllWhenShown(true);
	menuMgr.addMenuListener(new IMenuListener() {
  		public void menuAboutToShow(IMenuManager manager) {
    		// 创建上下文菜单
  		}
	});
	Menu menu = menuMgr.createContextMenu(viewer.getControl());
	[viewControl].setMenu(menu); //给视图控件添加上下文菜单。
	getSite().registerContextMenu(menuMgr, [ISelectionProvider]);//注册上下文菜单，以便通过扩展点实现。

#### ToolBar

	IActionBars bars = getViewSite().getActionBars();
	IToolBarManager manager = bars.getToolBarManager();
	manager.add(action1);
	manager.add(action2);


#### Local Menu

	IActionBars bars = getViewSite().getActionBars();
	IMenuManager manager = bars.getMenuManager();
	manager.add(action1);
	manager.add(new Separator());
	manager.add(action2);


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Plug-in Development Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Plug-in-Development-Tutorial) 下一篇：[Editors Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Editors-Tutorial)
