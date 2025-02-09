package main;

public class Main {
    public static void main(String[] args) {


        BankAccount account1 = new BankAccount("account1_iban", "Dragos", 1000);
        BankAccount account2 = new BankAccount("account2_iban", "Ana", 500);
        BankAccount account3 = new BankAccount("account3_iban", "Mihai", 780);
        BankAccount account4 = new BankAccount("account4_iban", "Adrian", 123);
        BankAccount account5 = new BankAccount("account5_iban", "Marius", 999);

        account1.displayAccountDetails();
        account1.deposit(500);
        account1.displayAccountDetails();

        System.out.println();

        account2.displayAccountDetails();
        account2.withdraw(700);
        account2.displayAccountDetails();
        account2.withdraw(200);
        account2.displayAccountDetails();


        System.out.println("person name: " + account3.getPersonName());
        System.out.println("iban: " + account3.getIban());

    }
}