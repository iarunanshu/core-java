package com.arunanshu.pillersofoops;

public class Encapsulation {
    /*
    Encapsulation is the bundling of data (attributes) and the methods (functions/behaviors) that operate on the data into a single unit, known as a class. It also involves restricting direct access to some of an object's components, typically its internal state (data), and controlling access through well-defined public methods. This is often referred to as "data hiding."
     */

    private String accountNumber; // Private data
    private double balance;       // Private data

    // Public getter method for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Public getter method for balance
    public double getBalance() {
        return balance;
    }
}