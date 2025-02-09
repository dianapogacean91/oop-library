package authors;

public class Author {

    private String name;
    private int age;
    private int nbBooksWritten;

    public Author(String name, int age, int nbBooksWritten) {
        this.name = name;
        this.age = age;
        this.nbBooksWritten = nbBooksWritten;
    }

    public String getName() {
        return this.name;
    }

    public void increment() {
        this.age++;
    }

    public int getAge() {
        return this.age;
    }

    public void increaseNbBooksWritten(int nb) {
        if (nb < 0) {
            System.out.println("Cannot increase nb books with negative value.");
        } else {
            this.nbBooksWritten += nb;
        }
    }

    public int getNbBooksWritten() {
        return this.nbBooksWritten;
    }

    public void displayAuthorDetails() {
        StringBuilder stringBuilder = new StringBuilder("name: ");
        stringBuilder.append(this.name).append(", age: ").append(this.age).append(", nb books written: ").append(this.nbBooksWritten);
        System.out.println(stringBuilder);
    }
}
