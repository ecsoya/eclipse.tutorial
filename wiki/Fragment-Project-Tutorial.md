---
layout: page
title: Fragment Project Tutorial
wikiPageName: Fragment-Project-Tutorial
menu: wiki
---

Fragment插件指的是一些插件的附属插件，它可以给主插件（Host Plug-in）提供一些特殊的功能。由于Fragment插件在运行之后会和主插件编译到一起，所以会和主插件里面的内容共融共通。

Fragment插件的用法一般有：

1. 作为主插件的测试组件，有时候一些插件可能有一些内部包也需要测试，就可以使用Fragment插件的方式。
2. 最常用的方式就是给一些插件添加多语言支持。
3. 某些插件的实现，可能会由于系统不同而有不同的实现方式，我们可以用Fragment插件的方式完成，比如SWT的实现。

### Language Translation

一，新建一个Fragment插件，Host Plug-in为`org.eclipse.jface`:

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_fragment_creation.png)

二，在Fragment插件中的src目录下，新建一个名为`org.eclipse.jface`的包，此包名必须和`org.eclipse.jface`插件中的包名一致。

三，将插件`org.eclipse.jface`中包`org.eclipse.jface`下的`messages.properties`复制到Fragment插件的`org.eclipse.jface`包中，并命名为`messages_zh.properties`。

四，将`messages_zh.properties`里面的内容改为中文。

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_fragment_jface.png)

五，测试

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_fragment_jface_msg.png)

>
>注意：运行时要将语言切换为中文。 
>
> 1. Eclipse Application: 将Run Configurations中Arguments页中的{target.nl}替换为zh。
> 2. Java Application：Locale.setDefault(Locale.CHINESE);

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇： [UpdateSite Project Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/UpdateSite-Project-Tutorial) 下一篇： [Eclipse 3.x RCP Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Eclipse-3.x-RCP-Tutorial)
