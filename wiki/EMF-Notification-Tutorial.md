---
layout: page
title: EMF Notification Tutorial
wikiPageName: EMF-Notification-Tutorial
menu: wiki
---

EMF生成的Java代码，支持事件的监听，所有的EStructuredFeature都能够通过添加Adapter来被监听。

### Adapters

常用的Adapter有两种。

一种是只针对当前实例的监听：

		library.eAdapters().add(new AdapterImpl(){
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
			}
		});

另一种是针对当前实例，以及里面所有的内容的监听：
		
		library.eAdapters().add(new EContentAdapter(){
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
			}
		});

### Notification

事件处理需要了解以下相关信息：

1. Notifier：触发事件的主体。
2. Event Type：事件的类型。
	* ADD：添加一个。
	* REMOVE：删除一个。
	* SET：设置新值。
	* UNSET：设置旧值。
	* ADD_MANY：添加多个，newValue是一个List。
	* REMOVE_MANY ：删除多个，oldValue是一个List。
	* RESOLVE：从代理中解析。
	* REMOVING_ADAPTER：删除监听。
3. Old Value：旧值。
4. New Value：新值。
5. isTouch：对于RESOLVE和REMOVING_ADAPTER来说返回true，其它类型返回false。

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[EMF Persisting Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Persisting-Tutorial) 下一篇：[EMF DataBinding Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-DataBinding-Tutorial)