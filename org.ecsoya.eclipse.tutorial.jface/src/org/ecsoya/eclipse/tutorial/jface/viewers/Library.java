package org.ecsoya.eclipse.tutorial.jface.viewers;

import java.util.ArrayList;
import java.util.List;

public class Library extends Model {

	public Library(String name) {
		super(name);
	}

	private List<Book> books;

	public List<Book> getBooks() {
		if (books == null) {
			books = new ArrayList<Book>();
		}
		return books;
	}

	public void setBooks(List<Book> books) {
		Object oldValue = this.books;
		this.books = books;
		support.firePropertyChange("books", oldValue, books);
	}

	public void addBook(Book book) {
		addChild(getBooks(), book, "books");
	}

	public void removeBook(Book book) {
		removeChild(books, book, "books");
	}

}
