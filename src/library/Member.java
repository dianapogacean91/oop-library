package library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Member {

    private static final short NB_DAYS = 30;
    private static int nbMembers = 0;
    private String cnp;
    private String name;
    private LocalDate birthdate;
    private boolean isStudent;
    private List<Book> borrowedBooks;


    public Member(String cnp, String name, LocalDate birthdate, boolean isStudent) {
        this.cnp = cnp;
        this.name = name;
        this.birthdate = birthdate;
        this.isStudent = isStudent;
        borrowedBooks = new LinkedList<>();
        nbMembers++;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.makeUnavailable();
            borrowedBooks.add(book);
           // book.setBorrowDateTime(LocalDateTime.now());
            book.setBorrowDateTime(LocalDateTime.now().minusDays(40));

            System.out.println("Borrowed book: " + book.getTitle());
        } else {
            System.out.println("Book " + book.getTitle() + "is already borrowed!");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.makeAvailable();
            borrowedBooks.remove(book);
            LocalDateTime dateNow = LocalDateTime.now();
            LocalDateTime dueDate = book.getBorrowDateTime().plusDays(NB_DAYS);
            if (dateNow.isAfter(dueDate)) {
                System.out.println("Over date that you should have returned! You must pay a fee.");
            }
            book.setBorrowDateTime(null);
        } else {
            System.out.println("This book " + book.getTitle() + "is not borrowed!");
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
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
