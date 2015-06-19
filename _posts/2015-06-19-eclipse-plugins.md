---
layout: post
title: Eclipse插件开发
---

## {{ page.title }}

### 1. 什么是Eclipse插件？
Eclipse是一款非常优秀的IDE，更多的我们是用来开发Java程序。当然，也有人用来开发Web，C和C++等相关的程序。

什么是eclipse插件呢？顾名思义，插件（plug-in）是可以可以安装到一些平台的程序，他会遵循平台的一些特定的接口，而平台呢会调用插件所提供的一些功能。简单的说，eclipse插件就是能够安装在eclipse平台的一些程序（以jar的方式）。

### 2. Eclipse下载与安装
Eclipse分为好多个版本，可以提供不同的功能给各种类型的开发人员。学习插件开发，你可以下载基本版或是RCP/RAP开发版本。

首先，打开 [Eclipse官网](http://www.eclipse.org/downloads)去下载Eclipse for RCP and RAP Developers, 如下图：

**[[images/home_download_eclipse.png]]**

安装很简单，只要将下好的文件解压到指定的目录OK了。

### 3. Hello World
下载好了Eclipse，接下来就是Hello World了。
找到解压好的文件，打开Eclipse的根目录，找到eclipse.exe，双击运行，指定一个工作空间（workspace）。
    _工作空间（workspace）是一个目录，在eclipse中的一些常用设置或是默认的工程和文件都会存储在这里。_

然后，写一个Hello World试试吧！

### 4. 再来几个插件的例子瞧瞧吧
`New` --> `Plug-in Project` --> <输入名字> --> `Rich Client Platform` （选择`Yes`）-->

**[[images/home_create_rcp.png]]**

然后点击`Next`或`Finish`完成。
一个RCP的例子就建好了，那么问题来了，怎么运行呢？
打开刚刚创建的project的`MANIFEST.MF`文件，找到`Testing`，点击`Launch an Eclipse Application`

**[[images/home_launch_rcp.png]]**

大功告成！

### 5. RCP是什么？与插件有什么关系？
RCP（Rich Client Platform），简单来说就是eclipse核心组件与一些特定的插件所组成的程序，他比普通的Java Application复杂而且功能丰富。通过运行上面的例子，你们也应该能看到，RCP运行起来的界面跟eclipse很相似，不过是少了好多的界面或是功能。这就对了，少了的那些东西，正是由一个一个的eclipse插件提供的。

### 6. Eclipse UI
Eclipse3.x及以下的版本中界面主要是通过SWT和JFace来实现的，Eclipse4之后的版本，逐渐加入了Java FX实现，不过要学习eclipse插件开发，就必须先对SWT和Jface有个系统的学习。接下来的章节我们就从SWT开始。

[Standard Widget Toolkit](https://github.com/ecsoya/eclipse.tutorial/wiki/Standard-Widget-Toolkit-(SWT))

***

参考资料：
 
 * [Eclipse Corner](https://wiki.eclipse.org/Eclipse_Corner)