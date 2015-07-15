---
layout: page
title: Plug-in Development Tutorial
wikiPageName: Plug-in-Development-Tutorial
menu: wiki
---

Eclipse是什么，首先我们想到最多的它是一个IDE，因为它是Java开发者中比较受欢迎的一款，另外也有人用它来开发Android，Web甚至是C、C++。那么Eclipse到底是什么？其实它只是一个平台，不同的IDE，只不过是安装了不同的组件而已。这些不同的组件我们称之为Eclipse插件。

### 什么是Eclipse插件

学习Eclipse插件开发，首先第一个问题肯定是，什么是Eclipse插件？

**首先**，我们可以想的简单一点：在Eclipse中，你看到的所有的东西，都是Eclipse插件。

**其次**，从文件结构的角度看，每一个plugins目录中的jar包都是一个Eclipse插件。

**再次**，从代码来看，每一个Eclipse插件都包含一个MANIFEST.MF的配置文件，有些还包含扩展实现文件plugin.xml。

**最后**，从功能方面来看，Eclipse插件可以是只包含Java源代码的工程，也可以是只包含文档的工程，也可以是只包含一些资源的工程。

### 怎么开发Eclipse插件

我们先认识Eclipse Workbench。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_plugin_workbench.png)

我们一般意义上说的插件开发，首先是从Eclipse Workbench开始的，因为你开发的插件，或多或少的都要通过Eclipse Workbench展现给用户。

我们要开发Eclipse插件就不得不提到Extension和Extension Point这两个概念。

1. **Extension**：是对Extension Point的实现，这个实现过程可以展示在一个或者多个plug-in中。
2. **Extension Point**：用来提供某个功能的实现方法或API，插件开发者可以很容易的去继承或者扩展这个功能。

比如：Eclipse Workbench提供了`org.eclipse.ui.views`这个扩展点，我们可以通过扩展这个扩展点来给Eclipse添加我们自己的视图（View）。

换句话说，对于Eclipse Workbench上面所有的东西（视图，编辑器，菜单等），Eclipse都提供了相应的扩展点，我们都可以去扩展。

我们通过以下一些常用的插件开发，来逐步的学习插件开发的技巧。

1. [View（视图）](http://ecsoya.github.io/eclipse.tutorial/wiki/Views-Tutorial)
2. [Editor（编辑器）](http://ecsoya.github.io/eclipse.tutorial/wiki/Editors-Tutorial)
3. [Actions（菜单，工具条）](http://ecsoya.github.io/eclipse.tutorial/wiki/Action-and-Menus-Tutorial)
4. [Preferences（首选项）](http://ecsoya.github.io/eclipse.tutorial/wiki/Preferences-Tutorial)

最后，我们还会通过[自定义扩展点（Extension Point）](http://ecsoya.github.io/eclipse.tutorial/wiki/ExtensionPoint-Tutorial)来详细的了解插件的继承与实现。

### 插件工程

插件工程通常有以下几种类型：

1. Plug-in Project：常规的插件工程。
2. [Feature Project](http://ecsoya.github.io/eclipse.tutorial/wiki/Feature-Project-Tutorial)：与打包发布相关的工程。
3. [Update Site Project](http://ecsoya.github.io/eclipse.tutorial/wiki/UpdateSite-Project-Tutorial)：与打包发布相关的工程。
4. [Fragment Project](http://ecsoya.github.io/eclipse.tutorial/wiki/Fragment-Project-Tutorial)：提供其它插件的Patch的工程。

### Plug-in Project

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

### 小结
>
> 1. 对于很多初学者来说，对Eclipse插件这个概念还是很模糊的，说是插件开发，结果一上来先学SWT和JFace，一堆界面开发的东西和Eclipse插件有什么关系？其实，Eclipse插件是要依赖依赖Eclipse这个平台来释放效果的，你开发的插件，只有放到了Eclipse平台上，显示在了Eclipse的Workbench上，才算是真正的Eclipse的插件，而与Eclipse Workbench就是基于SWT和JFace开发的，所以为什么我们在最开始先学习的是SWT和JFace的UI开发。
> 2. 难道插件开发就是SWT和JFace的UI开发吗？是，也不是。是是因为1中的那个问题（融入Workbench），不是是因为你的插件没有价值（没有实现真正的功能）。举个例子，作为Java开发者，你写好一个Java类之后会自动的编译成.class文件，简单的说你只是在一个文本的编辑器中输入了一些字符串（UI），这个功能在你所有的文本编辑器中都可以实现，但是Java编辑器在你的所有输入动作之后，在做着检查，编译等等的一系列你看不见的操作，这才是这个插件真正的价值所在。
> 3. 我们现在要学的，只是扩展Eclipse中的一些基本功能比如视图，编辑器之类的，这个扩展的过程就是插件开发的过程。在这里，提到扩展（Extension）和扩展点，我们也可以说插件开发就是实现扩展的过程。
> 4. 插件可以有狭义和广义两种分法：狭义来说，一个插件就是一个plug-in工程，最后它会被打包成一个jar包；广义来说，一个插件可以是一个项目，一个完整的产品，里面可以定义一个或多个plug-in工程，相应的也会被打包成一个或多个jar包。

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[JFace DataBinding Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-DataBinding-Tutorial) 下一篇：[Views Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Views-Tutorial)
