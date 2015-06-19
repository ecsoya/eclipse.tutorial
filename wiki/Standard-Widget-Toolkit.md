---
layout: page
title: Standard Widget Toolkit (SWT)
wikiPageName: Standard-Widget-Toolkit-(SWT)
menu: wiki
---

[SWT](http://www.eclipse.org/swt)是eclipse中用来开发界面的核心组件。它提供了按钮（Button），文本（Text），标签（Label）等等的基本组件，也拥有很多的布局管理（Layout Management）和事件处理机制（Event Handlers）。

SWT最大的特点是它不但能运行在多种操作系统（Windows， Mac OS及Linux），而且它的实现都是尽可能的应用JNI调用操作系统本地的API，所以生成的界面跟操作系统的风格比较接近。

### 1. Hello World
我们先来一个HelloWolrd看看吧。


    import org.eclipse.swt.widgets.Display;
    import org.eclipse.swt.widgets.Shell;

    public class HelloWorld {
    
    	public static void main(String[] args) {
            Display display = new Display();
            Shell shell = new Shell(display);
	        shell.setText("Hello World");
	        shell.setSize(300, 200);
	        shell.open();
		
	        while(!shell.isDisposed()){
	            if (!display.readAndDispatch()){
		            display.sleep();
		        }
	        }
	        display.dispose();
        }

    }


运行起来的效果如下：

![]({{site.baseurl}}/wiki/images/image_swt_helloworld.png)

我们来简单看一下这个例子，一个窗口，标题为“Hello World”，大小为300x200.
再来看一下代码，总共有两个对象，`Display`和`Shell`。然后对`Shell`进行了几个操作：

        shell.setText("Hello World"); //设置窗口的标题
        shell.setSize(300, 200); //设置窗口的大小
        shell.open();//打开窗口


### 2. [Display]({{site.baseurl}}/wiki/Display-Tutorial)和 [Shell]({{site.baseurl}}/wiki/Shell-Tutorial.html)

`org.eclipse.swt.widgets.Display`和`org.eclipse.swt.widgets.Shell`是SWT应用程序中最关键的两个组件。通过上面的例子应该清楚，`Shell`就相当于一个窗口。而`Display`呢，是用来管理SWT应用程序的最核心组件，所有的事件的监听，字体，颜色，图片等资源的创建和销毁以及多线程的处理，UI线程和非UI线程的交互等等，都离不开`Display`。

在每一个SWT的应用程序中，都至少有一个`Display`对象和一个`Shell`对象。

在上面的例子中，我们还看到下面一段代码：

	        while(!shell.isDisposed()){
	            if (!display.readAndDispatch()){
		            display.sleep();
		        }
	        }
	        display.dispose();
   
这些代码是用来做什么的呢？

1. `shell.isDisposed()`和`display.dispose()`：dispose，销毁？yes，SWT中创建的所有组件，用完之后是需要销毁的，而且一旦销毁了，就不能再使用了。啊？每个组件都要销毁，那我有那么多按钮啊，文本啊什么的，都要一个一个来销毁吗？no，也没有那么复杂，只要把最底层的那个容器（Composite）销毁就好了。
2. `display.readAndDispatch()`：read，读，dispatch，分发，没错，这句说的就是Display的重要功能，事件处理。因为SWT本身没有提供对各个组件的事件的监听，它是通过Display和本地系统建立一套循环监听的机制，当有任何事件（键盘，鼠标，触摸屏等）发生时，系统会第一时间把这些事件传递给Display，然后由Display分发到各个SWT控件中。
而当前这段语句，就是在判断，Display是否在进行事件的读写和分发。
3. `display.sleep()`：sleep，睡吗？没错，没事了就休息一会吧，不然老占用系统资源也不太地道。

### 3. 怎么应用SWT？

说了这么多，究竟SWT怎么用呢？

* 在普通的`Java Project`可以用。

    很简单，在`eclipse`的安装目录下的`plugins`中找到`SWT`的相关`jar`包，然后添加到你的`Java Project`的`Classpath`中就可   以用了。
    比如:`org.eclipse.swt.win32.win32.x86_64_3.103.2.v20150203-1351.jar`就是Windows x64操作系统中eclipse 4.4.2中的一个`jar`包。

*  在eclipse插件工程（Plug-in Project）中使用

    打开`Plug-in Project`的`MANIFEST.MF`文件，在依赖项（`Dependencies`）中加入`org.eclipse.swt`或`org.eclipse.ui`即可。实际上`org.eclipse.ui`会加入很多其它的`jar`包，包括`JFace`等。

So easy? 没错，赶紧试试上面的Hello World吧！

***

参考资料：

* [SWT Snippets](http://www.eclipse.org/swt/snippets/)
* [SWT Examples](http://www.eclipse.org/swt/examples.php)
* [Implementation Strategy for Java™ Natives](http://www.eclipse.org/articles/Article-SWT-Design-1/SWT-Design-1.html)
* [Managing Operating System Resources](http://www.eclipse.org/articles/swt-design-2/swt-design-2.html)
* [The SWT FAQ](https://www.eclipse.org/swt/faq.php)

***

下一篇：[SWT Widgets]({{site.baseurl}}/wiki/SWT-Widgets.html)
