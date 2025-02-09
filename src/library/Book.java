package library;

import authors.Author;

import java.util.Objects;

public class Book {

    private String isbn;
    private String title;
    private Author author;
    //TODO - extract to class
    private String publishing;

    private boolean available = true;

    public Book(String isbn, Author author, String title, String publishing) {
        this.isbn = isbn;
        //TODO - find why it searched in library jdk instead of my own package
        this.author = author;
        this.title = title;
        this.publishing = publishing;
    }


    public boolean isAvailable() {
        return this.available;
    }

    public void makeUnavailable() {
        if (!available) {
            System.out.println("This book is already borrowed!");
        } else {
            this.available = false;
        }
    }

    public void makeAvailable() {
        if (available) {
            System.out.println("Operation is invalid. Book is not yet borrowed.");
        } else {
            this.available = true;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void printBookDetails() {
        StringBuilder stringBuilder = new StringBuilder("isbn: ");
        stringBuilder.append(this.isbn).append(", title: ").append(this.title).append(", author:")
                .append(this.author.getName()).append(", publishing: ").append(this.publishing);
        System.out.println(stringBuilder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

}
