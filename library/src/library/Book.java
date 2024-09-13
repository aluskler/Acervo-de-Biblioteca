package library;

public class Book {
	private String title;
	private String author;
	private int releaseYear;

	public Book(String title, String author, int releaseYear) {
		this.title = title;
		this.author = author;
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	@Override
	public String toString() {
	    return "-----------------------------\n" +
	           "| Book Details               |\n" +
	           "-----------------------------\n" +
	           "| Title: " + title + "\n" +
	           "| Author: " + author + "\n" +
	           "| Release Year: " + releaseYear + "\n" +
	           "-----------------------------";
	}

}