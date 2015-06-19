package org.ecsoya.eclipse.tutorial.jface.viewers;

public class Book extends Model {

	private Author author;

	public Book(String name, Author author) {
		super(name);
		if (author != null) {
			author.addBook(this);
			this.author = author;
		}
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		Author oldValue = this.author;
		this.author = author;
		support.firePropertyChange("author", oldValue, author);
	}
}
