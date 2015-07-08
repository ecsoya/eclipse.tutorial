---
layout: page
title: EMF DataBinding Tutorial
wikiPageName: EMF-DataBinding-Tutorial
menu: wiki
---

在了解EMF DataBinding之前，你首先应该对[JFace DataBinding](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-DataBinding-Tutorial)有所了解。

### 简介

首先，将`org.eclipse.emf.databinding`加到依赖项中，查看`EMFProperties`类中的相关选项。总体来说可以将EMF的DataBinding项分成两类，一类是基于EStructuredFeature的，另一类是基于FeaturePath的。

其次，搞清楚绑定的对象是Value还是List或Set的。

### EMFProperties

	// Name value of library;
	EMFProperties.value(LibraryPackage.eINSTANCE.getLibrary_Name()).observe(library)

	// Book list of library
	EMFProperties.value(LibraryPackage.eINSTANCE.getLibrary_Books()).observe(library)

### 示例


		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("EMF DataBinding Example");

		shell.setLayout(new GridLayout(2, true));

		Composite control = new Composite(shell, SWT.NONE);
		control.setLayout(new GridLayout(2, false));
		control.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		// Model
		final Library library = LibraryFactory.eINSTANCE.createLibrary();
		LibraryFactory factory = LibraryFactory.eINSTANCE;

		library.setName("Ecsoya");

		Book book = factory.createBook();
		book.setTitle("King Lear");

		Writer writer = factory.createWriter();
		writer.setName("William Shakespeare");
		book.setWriter(writer);

		library.getBooks().add(book);

		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMLResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(LibraryPackage.eNS_URI,
				LibraryPackage.eINSTANCE);
		final Resource resource = resourceSet.createResource(URI
				.createFileURI("demo.xml"));
		resource.getContents().add(library);

		Composite content = new Composite(shell, SWT.NONE);
		content.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		content.setLayout(new GridLayout());
		Button button = new Button(content, SWT.NONE);
		button.setText("Update...");
		final Text contentText = new Text(content, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		contentText.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		button.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				try {
					ByteArrayOutputStream stream = new ByteArrayOutputStream(
							100);
					resource.save(stream, Collections.EMPTY_MAP);
					contentText.setText(new String(stream.toByteArray()));
					stream.close();
				} catch (IOException e) {
					contentText.setText("");
				}
			}
		});

		// Widgets
		Label label = new Label(control, SWT.NONE);
		label.setText("Library:");

		// Library name
		final Text text = new Text(control, SWT.BORDER);

		// Books
		label = new Label(control, SWT.NONE);
		label.setText("Books:");
		final TableViewer tableViewer = new TableViewer(control);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableViewer.setContentProvider(new ArrayContentProvider());

		TableViewerColumn nameCol = new TableViewerColumn(tableViewer, SWT.NONE);
		nameCol.getColumn().setText("Title");
		nameCol.getColumn().setWidth(150);
		nameCol.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof Book) {
					return ((Book) element).getTitle();
				}
				return super.getText(element);
			}
		});

		TableViewerColumn writerCol = new TableViewerColumn(tableViewer,
				SWT.NONE);
		writerCol.getColumn().setText("Writer");
		writerCol.getColumn().setWidth(150);
		writerCol.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if (element instanceof Book) {
					Writer writer = ((Book) element).getWriter();
					return writer == null ? "" : writer.getName();
				}
				return super.getText(element);
			}
		});

		final Realm realm = SWTObservables.getRealm(display);
		Realm.runWithDefault(realm, new Runnable() {

			@Override
			public void run() {

				DataBindingContext context = new DataBindingContext(realm);

				// Bind name of library to a text.
				context.bindValue(
						WidgetProperties.text(SWT.Modify).observe(text),

						// Name value of library;
						EMFProperties.value(
								LibraryPackage.eINSTANCE.getLibrary_Name())
								.observe(library),

						new UpdateValueStrategy(
								UpdateValueStrategy.POLICY_UPDATE),
						new UpdateValueStrategy(
								UpdateValueStrategy.POLICY_UPDATE));

				//
				context.bindValue(
						ViewerProperties.input().observe(tableViewer),

						// Book list of library
						EMFProperties.value(
								LibraryPackage.eINSTANCE.getLibrary_Books())
								.observe(library),

						new UpdateValueStrategy(
								UpdateValueStrategy.POLICY_UPDATE),
						new UpdateValueStrategy(
								UpdateValueStrategy.POLICY_UPDATE));
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[EMF Notification Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/EMF-Notification-Tutorial)
