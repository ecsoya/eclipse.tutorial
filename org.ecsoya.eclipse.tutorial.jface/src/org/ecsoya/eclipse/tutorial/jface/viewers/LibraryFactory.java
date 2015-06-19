package org.ecsoya.eclipse.tutorial.jface.viewers;

import java.util.ArrayList;
import java.util.List;

public class LibraryFactory {

	public static Library createLibrary1() {
		Library library = new Library("Center Public Library");

		library.addBook(new Book("Children Education, 3-6 years old",
				new Author("Ben Jermain", 34)));
		library.addBook(new Book("Children Education, 6-12 years old",
				new Author("Ben Jermain", 34)));

		library.addBook(new Book("Baby Names Book", new Author("Quan Jia", 56)));
		library.addBook(new Book("Java Development", new Author("Van Jondon",
				43)));

		return library;
	}

	public static Library createLibrary2() {
		Library library = new Library("Sample Library");

		for (int i = 0; i < 5; i++) {
			Book book = new Book("Book " + (i + 1), new Author("Author"
					+ (i + 1), 20 + (i * 2)));
			library.addBook(book);
		}
		return library;
	}

	public static List<Library> getLibraries() {
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(createLibrary1());
		libraries.add(createLibrary2());
		return libraries;
	}
}
