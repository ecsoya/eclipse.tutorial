---
layout: page
title: EMF Persisting Tutorial
wikiPageName: EMF-Persisting-Tutorial
menu: wiki
---

### Java

通常情况下，EMF生成的代码会有一个Factory类，用来创建不同的模型。

	LibraryFactory factory = LibraryFactory.eINSTANCE; 
	
	Library library = factory.createLibrary();
	library.setName("Ecsoya");
		
	Book book = factory.createBook(); 
	book.setTitle("King Lear"); 

	Writer writer = factory.createWriter(); 
	writer.setName("William Shakespeare"); 
	book.setWriter(writer);

	library.getBooks().add(book);

### 存储

	// Create a resource set to hold the resources.
	//
	ResourceSet resourceSet = new ResourceSetImpl();
	
	// Register the appropriate resource factory to handle all file extensions.
	//
	resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new XMIResourceFactoryImpl());

	// Register the package to ensure it is available during loading.
	//
	resourceSet.getPackageRegistry().put
		(LibraryPackage.eNS_URI, 
		 LibraryPackage.eINSTANCE);
        
	try {
		Resource resource = resourceSet.createResource(URI.createURI("http:///My.library"));
		resource.getContents().add(library);
		resource.save(System.out, null);
	}
	catch (IOException exception) {
		exception.printStackTrace();
	}

保存的模型如下：

	<?xml version="1.0" encoding="ASCII"?>
	<lib:Library xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:lib="http://ecsoya/eclipse/tutorial/library" name="Ecsoya">
  		<books title="King Lear">
    		<writer name="William Shakespeare"/>
  		</books>
	</lib:Library>


### 加载

	try {
		// Demand load resource for this file.
		//
		Resource resource = resourceSet.getResource(uri, true);
		System.out.println("Loaded " + uri);

		// Validate the contents of the loaded resource.
		//
		for (EObject eObject : resource.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE
					.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				printDiagnostic(diagnostic, "");
			}
		}
	} catch (RuntimeException exception) {
		System.out.println("Problem loading " + uri);
		exception.printStackTrace();
	}
			

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)
上一篇：[EMF Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Tutorial) 下一篇：[EMF Notification Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Notification-Tutorial)
