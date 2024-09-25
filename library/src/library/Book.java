package library;

public class Book {
    private String title;
    private String author;
    private int releaseYear;
    private String genre;  // Adicionando o campo 'genre' (tema)

    public Book(String title, String author, int releaseYear, String genre) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
               "| Book Details               |\n" +
               "-----------------------------\n" +
               "| Title: " + title + "\n" +
               "| Author: " + author + "\n" +
               "| Release Year: " + releaseYear + "\n" +
               "| Genre: " + genre + "\n" +
               "-----------------------------";
    }
}
