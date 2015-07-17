---
layout: page
title: Product Configuration Tutorial
wikiPageName: Product-Configuration-Tutorial
menu: wiki
---

Product Configuration用来配置RCP的所有的信息，包括插件，依赖，运行环境等。

### Product Configuration

一，新建一个Product Configuration配置文件

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_1.png)

输入名称，并且选择创建源，一般情况下我们会根据RCP的运行记录去创建。
> 创建源的选择：
> 
> 1. Create a configuration file with basic settings：空白创建。 
> 2. Use an existing product：通过其它的Product Configuration文件来创建。
> 3. Use a launch configuration：这个是最简单最准确的，但前提是你的RCP必须通过_`Launch an Eclipse application`_选项成功运行一次之后。

二，确定**Product Definition**中的*Product*和*Application*是否正确。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_2.png)

三，通过**plugins**或**features**两种方式来配置RCP的依赖插件。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_3.png)

四，配置RCP启动时的一些信息，默认保持不动。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_4.png)

五，配置RCP的运行时的一些基本信息，如运行环境，参数等等。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_5.png)

六，配置**Splash**图片，进度条等信息。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_7.png)

Splash

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_6.png)

七，配置**Branding**信息，如RCP的图片，关于对话框（About Dialog）内容，欢迎页面（Welcome Page）。

About Dialog

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_8.png)

Welcome Page

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_intro.png)

八，配置**license**信息

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_license.png)

九，配置**Update**信息

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_updates.png)

###　Export

在Product编辑器的右上角有一个Export的工具，可以将RCP打包成产品：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_export.png)

打包之后的RCP结构如下：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_export2.png)

不过在打包之前，你应该先对当前的RCP进行验证（Validate）：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_rcp_product_validate.png)

验证的主要作用是保证当前RCP中的所有插件及其依赖是完整的。

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[Eclipse 3.x RCP Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Eclipse-3.x-RCP-Tutorial) 下一篇：[Eclipse Modeling Framework Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Tutorial)