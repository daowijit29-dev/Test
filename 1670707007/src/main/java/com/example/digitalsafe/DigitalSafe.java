package com.example.digitalsafe;

/**
 * DigitalSafe class that demonstrates encapsulation
 * Can only deposit money, cannot withdraw money
 */
public class DigitalSafe {
    private String ownerName;
    private double balance;

    // Constructor
    public DigitalSafe(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Deposit method (only positive values)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for owner name
    public String getOwnerName() {
        return ownerName;
    }
}
