package main;

public class BankAccount {

    private String iban;
    private String personName;
    private double balance;


    public BankAccount(String iban, String personName, double balance) {
        this.iban = iban;
        this.personName = personName;
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    //withdraw
    public void withdraw(double amount) {

        if (amount < 0) {
            System.out.println("Amount is negative! Invalid value for: " + amount);
        } else {
            if (this.balance - amount < 0) {
                System.out.println("The amount you want to retrive is higher than your balance.");
                return;
            }
            this.balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Amount is negative! Invalid value for: " + amount);
        } else {
            this.balance += amount;
        }
    }

    public String getIban() {
        return this.iban;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void displayAccountDetails() {
        System.out.println("For account: " + this.iban + ", current balance is: " + this.balance);
    }

}
