package library;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Member {

    private static int nbMembers = 0;

    private String cnp;
    private String name;
    private int age;
    private boolean isStudent;
    private List<Book> borrowedBooks;


    public Member(String cnp, String name, int age, boolean isStudent) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
        borrowedBooks = new LinkedList<>();
        nbMembers++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.makeUnavailable();
            borrowedBooks.add(book);
            System.out.println("Borrowed book: " + book.getTitle());
        } else {
            System.out.println("Book " + book.getTitle() + "is already borrowed!");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.makeAvailable();
            borrowedBooks.remove(book);
        } else {
            System.out.println("This book " + book.getTitle() + "is not borrowed!");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(cnp, member.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }
}
