package com.mycompany.atmmachine;

/**
 *
 * @author Turki
 */
import java.util.*;

public class Account {

    private double balance;
    private double previousTransaction;
    private String name;
    private String id;

    public Account(String name, String id) {
        this.name = name;
        this.id = id;
    }

    private void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    private void withdraw(double amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn:" + previousTransaction);
        } else {
            System.out.println("No transactions yet!");
        }
    }

    private void calculateInterst(int years) {
        double rate = 0.05;
        double newBalance = (balance * rate * years) + balance;
        System.out.println("current intrest rate: " + (100 * rate)+"%");
        System.out.println("In " + years + " years, your balancne will be: " + newBalance);
    }

    public void ShowMenu() {
        int selection;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("Welcome, " + name + " !\n"
                + "Your ID: " + id + "\n\nSelect an opration:"
                + "\n[1]Check balance" + "\n"
                + "[2]Deposit\n"
                + "[3]withdraw\n"
                + "[4]previous Transactions\n"
                + "[5]Interest rate\n"
                + "[6]Exit\n");
            int o1 = input.nextInt();
            selection = o1;
            System.out.println("");
            switch (selection) {
                case 1 -> {
                    System.out.println("##################");
                    System.out.println("Balanec = $ " + balance);
                    System.out.println("##################\n");
                }
                case 2 -> {
                    System.out.println("enter amount to deposit: ");
                    double amount = input.nextDouble();
                    deposit(amount);
                    System.out.println("");
                }
                case 3 -> {
                    System.out.println("withdraw amount: ");
                    double amount1 = input.nextDouble();
                    withdraw(amount1);
                    System.out.println("");
                }
                case 4 -> {
                    System.out.println("##################");
                    getPreviousTransaction();
                    System.out.println("##################\n");
                }
                case 5 -> {
                    System.out.println("How many years do you want:");
                    int year = input.nextInt();
                    calculateInterst(year);
                }
                case 6 -> System.out.println("##################");
                default -> System.out.println("Wrong input!!");
            }

        } while (selection != 6);
        System.out.println("Thank you for using our bank! :)");

    }

}
