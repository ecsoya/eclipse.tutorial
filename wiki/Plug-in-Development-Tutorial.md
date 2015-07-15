---
layout: page
title: Plug-in Development Tutorial
wikiPageName: Plug-in-Development-Tutorial
menu: wiki
---

Eclipse是什么，首先我们想到最多的它是一个IDE，因为它是Java开发者中比较受欢迎的一款，另外也有人用它来开发Android，Web甚至是C、C++。那么Eclipse到底是什么？其实它只是一个平台，不同的IDE，只不过是安装了不同的组件而已。这些不同的组件我们称之为Eclipse插件。

### 什么是Eclipse插件

学习Eclipse插件开发，首先第一个问题肯定是，什么是Eclipse插件？

首先，我们可以想的简单一点：在Eclipse中，你看到的所有的东西，都是Eclipse插件。

其次，从文件结构的角度看，每一个plugins目录中的jar包都是一个Eclipse插件。

再次，从代码来看，每一个Eclipse插件都包含一个MANIFEST.MF的配置文件，有些还包含扩展实现文件plugin.xml。

最后，从功能方面来看，Eclipse插件可以是只包含Java源代码的工程，也可以是只包含文档的工程，也可以是只包含一些资源的工程。

### 怎么开发Eclipse插件

我们先认识Eclipse Workbench。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugin_workbench.png)

我们一般意义上说的插件开发，首先是从Eclipse Workbench开始的，因为你开发的插件，或多或少的都要通过Eclipse Workbench展现给用户。

我们通过以下一些常用的插件开发，来逐步的学习插件开发的技巧。

1. [View（视图）](http://ecsoya.github.io/eclipse.tutorial/wiki/Views-Tutorial)
2. [Editor（编辑器）](http://ecsoya.github.io/eclipse.tutorial/wiki/Editors-Tutorial)
3. [Actions（菜单，工具条）](http://ecsoya.github.io/eclipse.tutorial/wiki/Action-and-Menus-Tutorial)
4. [Preferences（首选项）](http://ecsoya.github.io/eclipse.tutorial/wiki/Preferences-Tutorial)

最后，我们还会通过[自定义扩展点（Extension Point）](http://ecsoya.github.io/eclipse.tutorial/wiki/ExtensionPoint-Tutorial)来详细的了解插件的继承与实现。

### 插件工程

1. Plug-in Project
2. [Feature Project](http://ecsoya.github.io/eclipse.tutorial/wiki/Feature-Project-Tutorial)
3. [Update Site Project](http://ecsoya.github.io/eclipse.tutorial/wiki/UpdateSite-Project-Tutorial)
4. [Fragment Project](http://ecsoya.github.io/eclipse.tutorial/wiki/Fragment-Project-Tutorial)

### 示例

1.右键菜单选择新建插件工程（Plug-in Project）

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-1.png)

2.输入插件工程名称，并下一步

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-2.png)

3.配置插件的基本信息，ID，Name，Version和Vendor等。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-3.png)

4.选择Hello-World模板

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-4.png)

5.配置Hello-World模板的基本信息

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-5.png)

6.生成插件工程，并运行Eclipse插件。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-6.png)

7.运行之后，如图

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-7.png)

8.点击Sample Menu，预览插件实现内容。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/create-plugin-8.png)



***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[JFace DataBinding Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-DataBinding-Tutorial) 下一篇：[Views Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Views-Tutorial)
