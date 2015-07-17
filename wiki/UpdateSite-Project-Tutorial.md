---
layout: page
title: UpdateSite Project Tutorial
wikiPageName: UpdateSite-Project-Tutorial
menu: wiki
---

Update Site Porject是专门针对Eclipse插件安装与更新的工程。

### Update Site Map

通过向导创建一个Update Site Project之后，你会发现所有的东西都写在一个`site.xml`文件中。

首先，你需要创建Category用来描述你的插件。

然后，你需要将你的Feature添加到Update Site Map中：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_update_site.png)

最后，`Synchronize...` 和 `Build`

### site.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<site>
   		<feature url="features/org.ecsoya.eclipse.tutorial.feature_1.0.0.qualifier.jar" 
   			id="org.ecsoya.eclipse.tutorial.feature" version="1.0.0.qualifier">
      		<category name="Ecsoya Tutorials"/>
   		</feature>
   		<category-def name="Ecsoya Tutorials" label="Ecsoya Tutorials"/>
	</site>

### Build

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_update_site_build.png)

Build完成后，你就可以发布你的插件了。


> 所谓发布就是将Update Site Project下的所有东西（保持目录结构）Copy到你的服务器上，最终将site.xml连接提供给用户就可以了，如`http://yoursite/youtplugins/site.xml`。当然，你也可以将`site.xml`重命名为`index.html`然后只提供`http://yoursite/youtplugins/`。

### Install

在Build完成后，你可以进行一些测试安装，将你当前的Update Site Project的目录作为根目录安装插件。

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_update_site_install.png)


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇： [Feature Project Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Feature-Project-Tutorial) 下一篇： [Fragment Project Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Fragment-Project-Tutorial)
