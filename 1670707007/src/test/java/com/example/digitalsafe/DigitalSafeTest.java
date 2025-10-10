package com.example.digitalsafe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DigitalSafeTest {

    @Test
    public void testDigitalSafeCreation() {
        DigitalSafe safe = new DigitalSafe("Test Owner");
        assertEquals("Test Owner", safe.getOwnerName());
        assertEquals(0.0, safe.getBalance());
    }

    @Test
    public void testDepositPositiveAmount() {
        DigitalSafe safe = new DigitalSafe("Test Owner");
        safe.deposit(100.0);
        assertEquals(100.0, safe.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        DigitalSafe safe = new DigitalSafe("Test Owner");
        assertThrows(IllegalArgumentException.class, () -> {
            safe.deposit(-50.0);
        });
        assertEquals(0.0, safe.getBalance());
    }

    @Test
    public void testDepositZeroAmount() {
        DigitalSafe safe = new DigitalSafe("Test Owner");
        assertThrows(IllegalArgumentException.class, () -> {
            safe.deposit(0.0);
        });
        assertEquals(0.0, safe.getBalance());
    }

    @Test
    public void testMultipleDeposits() {
        DigitalSafe safe = new DigitalSafe("Test Owner");
        safe.deposit(100.0);
        safe.deposit(50.0);
        safe.deposit(25.0);
        assertEquals(175.0, safe.getBalance());
    }
}
