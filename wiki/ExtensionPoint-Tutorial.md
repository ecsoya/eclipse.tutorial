---
layout: page
title: ExtensionPoint Tutorial
wikiPageName: ExtensionPoint-Tutorial
menu: wiki
---

扩展点（Extension Point）是实现Eclipse插件开发的关键，视图（View），编辑器（Editor）以及菜单工具栏的添加都是通过实现扩展点来完成的。

一个扩展点，可以被一个或多个插件扩展（Extension）一次到多次。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extension_overview.png)

### Extension Point

扩展点是通过一个扩展的xsd文件（exsd）定义的，我们可以在扩展描述文件plugin.xml中找到它。

打开插件的MANIFEST文件，切换到Extension Points页面，我们就可以新建或者删除一个扩展点。

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_create.png)

1. Extension Point ID：扩展点的标识（Internal ID）。`注意：在外部使用的时候当前扩展点的ID=[Plugin ID].[Internal ID]。`
2. Extension Point Name：扩展点的名称。
3. Extension Point Schema：扩展点的描述文件。

### Extension Point Schema

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_schema.png)

所有的扩展点的内容，都是通过这个Schema文件来定义的。Schema中的元素有：

1. Element：节点元素。
2. Attribute：每个节点的基本属性。
3. Compositor：节点的引用关系属性。（详细请参考XSD）
	1. Choice：无序的。
	2. Sequence：有序的。

#### Element

Element的定义比较简单，你只需要提供Name就可以。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_element.png)

#### Attribute

Attribute的定义除了Name之外，还有两个比较关键的部分：

1. Use：定义属性的级别。
	* optional：可选的，在实现扩展的时候是一个可选项。
	* required：必须的，在实现扩展的时候必须提供一个值。
	* default：可以在定义扩展点的时候设定一个默认值。
2. Type：属性的类型。
	* string：任意字符串。
	* boolean：true或false。
	* java：指定的Java类，通常会设定一个接口或是父类作为指定的Java类的超级类。
	* resource：任意类型的资源，比如文件或图片。
	* identifier：引用其它扩展的ID。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_attribute.png)

#### Compositor

定义引用关系，如图

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_choice.png)

每个引用关系中可以定义具体的引用的Element，如图

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_extensionpoint_element_ref.png)

其实，你可以看到在定义引用关系的时候，会有`Min Occurrences`和`Max Occurrences`来定义引用的边界（Bounds）。

这些你都可以在XSD中找到相应的解释。


### Accessing Extension Points

定义好了扩展点，就需要知道如何去读取别人的扩展（Entension）。

当然了，Eclipse定义好了方法，你可以通过IExtensionRegistry来读取：

	IConfigurationElement[] elements = Platform
       .getExtensionRegistry()
       .getConfigurationElementsFor(
        "org.ecsoya.eclipse.tutorial.extensionpoints.viewItemProvider");
	List<IViewItemProvider> providers = new ArrayList<IViewItemProvider>();
	for (IConfigurationElement elt : elements) {
 		try {
    		IViewItemProvider p = (IViewItemProvider) elt.createExecutableExtension("class");
     		providers.add(p);
   		} catch (CoreException e) {
      		e.printStackTrace();
   		}
	}

> 注意点：
> 
> 1. 扩展点真正的ID一定要加上当前插件的ID才可以。
> 2. 读到的每一个IConfigurationElement，都是一个扩展实现对应的元素，可以从里面取到所有实现的属性和引用。
> 3. 对于Java类型的属性来说，会直接创建一个Java对象出来。


***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Preferences Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Preferences-Tutorial) 下一篇：[Publish Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Publish-Tutorial)
