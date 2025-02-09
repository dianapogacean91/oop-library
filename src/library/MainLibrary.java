package library;

import authors.Author;

import java.util.List;

public class MainLibrary {


    public static void main(String[] args) {

        Author mihaiEminescu = new Author("Mihai Eminescu", 40, 1200);
        Author ionCreanga = new Author("Ion Creanga", 60, 2000);
        Author ionLucaCaragiale = new Author("Ion Luca Caragiale", 50, 1234);

        Book book1 = new Book("87u9738473743", mihaiEminescu, "Poezii vol 1", "Editura Rao");
        Book book2 = new Book("87u9738473744", mihaiEminescu, "Poezii vol 2", "Editura Rao");
        Book book3 = new Book("87u9738473745", ionCreanga, "Povestiri 1", "Editura Rao");
        Book book4 = new Book("87u9738473746", ionCreanga, "Basme", "Editura Rao");
        Book book5 = new Book("87u9738473748", ionLucaCaragiale, "Dnul Goe", "Editura Rao");

        Member member1 = new Member("2910807124936", "Diana Pogacean", 33, false);
        Member member2 = new Member("2910807124937", "Ana Pop", 20, true);
        Member member3 = new Member("2910807124938", "Alexandra Manole", 25, false);
        Member member4 = new Member("2910807124939", "Adrian Vasile", 21, true);
        Member member5 = new Member("2910807124931", "Maria Popescu", 33, false);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
        library.addMember(member4);
        library.addMember(member5);

        library.borrowBook("2910807124936", "87u9738473748");
        library.borrowBook("2910807124938", "87u9738473748");

        library.listAllBorrowedBooks();

        List<Book> booksByEminescu = library.find("Mihai Eminescu");
        System.out.println("Books by eminescu: ");
        if (booksByEminescu.size() == 0) {
            System.out.println("No books by eminescu!");
        }
        for (Book book : booksByEminescu) {
            System.out.println(book.getTitle());
        }


        List<Book> notExistentBooks = library.find("blabla");
        System.out.println("Books by blabla: ");
        if (notExistentBooks.size() == 0) {
            System.out.println("No books by blabla!");
        }


    }
}
