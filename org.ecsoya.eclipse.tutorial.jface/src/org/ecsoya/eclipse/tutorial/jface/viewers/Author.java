package org.ecsoya.eclipse.tutorial.jface.viewers;

import java.util.ArrayList;
import java.util.List;

public class Author extends Model {

	private int age;

	private List<Book> books;

	public Author(String name, int age) {
		super(name);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		support.firePropertyChange("age", oldValue, age);
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (age != other.age)
			return false;
		return true;
	}

}
