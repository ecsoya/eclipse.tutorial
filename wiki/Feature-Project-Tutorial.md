---
layout: page
title: Feature Project Tutorial
wikiPageName: Feature-Project-Tutorial
menu: wiki
---

Eclipse Features指的是一个或一组插件的集合，前面我们已经提过，广义上来说一个Eclipse插件可以是一个包含多个Plug-ins产品，那么Feature就是这样的一个概念，它里面就可以定义多个Plug-in作为一个集体，它甚至可以包含其它的一些Feature。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_feature_overview.png)

### Feature Project

我们可以通过向导来创建一个Feature Project。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_feature_creation.png)

### feature.xml

Feature Project主要由一个feature.xml文件组成，里面可以定义名称，版本，插件描述，版权信息，许可信息等内容。

	<?xml version="1.0" encoding="UTF-8"?>
	<feature
    	id="org.ecsoya.eclipse.tutorial.feature"
      	label="Feature Tutorial"
      	version="1.0.0.qualifier"
      	provider-name="Ecsoya">

   		<description url="http://www.example.com/description">
      		[Enter Feature Description here.]
   		</description>

   		<copyright url="http://www.example.com/copyright">
      		[Enter Copyright Description here.]
   		</copyright>

   		<license url="http://www.example.com/license">
      		[Enter License Description here.]
   		</license>

	   <plugin
	   		id="org.ecsoya.eclipse.tutorial"
         	download-size="0"
         	install-size="0"
         	version="0.0.0"
         	unpack="false"/>

	</feature>

### Export

Feature的打包也很简单：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_feature_export1.png)

打包之后，所有的插件就会被打成jar包。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_feature_export2.png)


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇： [Publish Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Publish-Tutorial) 下一篇： [Update Site Project Tutorial](http://http://ecsoya.github.io/eclipse.tutorial/wiki/UpdateSite-Project-Tutorial)