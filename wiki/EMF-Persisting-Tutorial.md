---
layout: page
title: EMF Persisting Tutorial
wikiPageName: EMF-Persisting-Tutorial
menu: wiki
---

### 使用EMF生成的Java代码

通常情况下，EMF生成的代码会有一个Factory类，用来创建不同的模型。

	LibraryFactory factory = LibraryFactory.eINSTANCE; 
	Book book = factory.createBook(); 

	Writer writer = factory.createWriter(); 
	writer.setName("William Shakespeare"); 

	book.setTitle("King Lear"); 
	book.setAuthor(writer);


### 存储

	ResourceSet resourceSet = new ResourceSetImpl();
	Resource resource = resourceSet.createResource(URI.createFileURI("demo.xml"));
	resource.getContents().add(book);
	resource.save(Collections.EMPTY_MAP);

### 加载

	ResourceSet resourceSet = new ResourceSetImpl();
	Resource resource = resourceSet.createResource(URI.createFileURI("demo.xml"));
	resource.load(Collections.EMPTY_MAP);
			
	EList<EObject> contents = resource.getContents();
	for (EObject eObject : contents) {
		//your model
	}
			

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[EMF Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Tutorial) 下一篇：[EMF Notification Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Notification-Tutorial)
