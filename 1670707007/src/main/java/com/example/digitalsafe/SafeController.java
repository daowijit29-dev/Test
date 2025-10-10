package com.example.digitalsafe;

import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Digital Safe API
 * Demonstrates encapsulation through API endpoints
 */
@RestController
@RequestMapping("/safe")
public class SafeController {

    private final DigitalSafe safe = new DigitalSafe("Smine"); // Set safe owner name

    // GET /safe/owner - Get owner name
    @GetMapping("/owner")
    public String getOwnerName() {
        return "Owner: " + safe.getOwnerName();
    }

    // GET /safe/balance - Get current balance
    @GetMapping("/balance")
    public String getBalance() {
        return "Current balance: " + safe.getBalance();
    }

    // POST /safe/deposit?amount=1000 - Deposit money
    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        try {
            safe.deposit(amount);
            return "Deposited " + amount + " successfully. New balance: " + safe.getBalance();
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
