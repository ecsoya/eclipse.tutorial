package org.ecsoya.eclipse.tutorial.emf.databindings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.ecsoya.eclipse.tutorial.library.Book;
import org.ecsoya.eclipse.tutorial.library.Library;
import org.ecsoya.eclipse.tutorial.library.LibraryFactory;
import org.ecsoya.eclipse.tutorial.library.LibraryPackage;
import org.ecsoya.eclipse.tutorial.library.Writer;

public class EMFDataBindingExample {

	public static void main(String[] args) {
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

	}

}
