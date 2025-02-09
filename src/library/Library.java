package library;

import authors.Author;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new LinkedList<>();
        this.members = new LinkedList<>();
    }

    public void addBook(Book book) {
        if (this.books.contains(book)) {
            System.out.println("This book already exists: " + book.getIsbn());
            return;
        }
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
            return;
        }
        System.out.println("This book does not exists: " + book.getIsbn());
    }

    public void addMember(Member member) {
        if (this.members.contains(member)) {
            System.out.println("This member already exists" + member);
            return;
        }
        this.members.add(member);
    }

    public void removeMember(Member member) {
        if (this.members.contains(member)) {
            this.members.remove(member);
            return;
        }
        System.out.println("This member does not exists: " + member.getName());
    }

    public void borrowBook(String cnp, String isbn) {
        Book foundBook = null;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                foundBook = book;
                break;
            }
        }
        if (foundBook == null) {
            System.out.println("Book with this isbn not found!");
            return;
        }

        Member foundMember = null;

        for (Member member : this.members) {
            if (member.getCnp().equals(cnp)) {
                foundMember = member;
                break;
            }
        }
        if (foundMember == null) {
            System.out.println("Member with this cnp not found!");
            return;
        }

        foundMember.borrowBook(foundBook);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void listAllBorrowedBooks() {
        for (Member member : this.members) {
            if (member.getBorrowedBooks().size() != 0) {
                System.out.println("Books borrowed by: " + member.getName());
                for (Book book : member.getBorrowedBooks()) {
                    System.out.println(book.getIsbn() + "," + book.getTitle());
                }
            }
        }
    }


    public List<Book> find(String name) {
        //enhanced for
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getAuthor().getName().equals(name)) {
                foundBooks.add(book);
            }
        }

        return foundBooks;

        //ugly code
//        for (int i = 0; i < this.books.size(); i++) {
//            this.books.get(i);
//        }
    }


    //TODO -- return book
    //TODO -- find book by title
    //TODO -- find member by name
    //TODO -- list all books in library
    //TODO -- find all books by a publishing
}
