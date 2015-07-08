---
layout: page
title: Display Tutorial
wikiPageName: Display-Tutorial
menu: wiki
---

### 简介
Display是SWT用来连接底层操作系统的一个非常重要的组件。通常，它也负责UI界面同底层操作系统的交互，比如监听操作系统的键盘，鼠标等的事件，反馈等等。

在SWT中，很多系统都只支持一个Display的实例，也就是说在一个Display没有调用dispose()方法销毁之前，是不允许创建第二个Display的。

### UI Thread

在SWT中，用来创建Display的线程（Thread）被称为UI线程（UI thread）。
所有的有关UI界面的操作，都必须在UI线程中完成，否则会报出“*ERROR_THREAD_INVALID_ACCESS*”的异常。

在非UI线程中，可以通过以下方法调用UI线程：

* **asyncExec (Runnable runnable)**：异步执行，和其它的进程并行执行。
* **syncExec (Runnable runnable)**：同步执行，等其它的进程执行完之后，顺序执行。
* **timerExec (int milliseconds, Runnable runnable)**：延迟执行。

### Display调取系统资源

* Display.getSystemColor()
* Display.getSystemFont()
* Display.getSystemCursor()
* Display.getSystemImage()
* Display.getSystemTaskBar()
* Display.getSystemTray()


***

[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
