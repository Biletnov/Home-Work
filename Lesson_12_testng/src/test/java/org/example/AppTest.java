package org.example;

import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AppTest {
    
    @Test
    public void testFactorialOfZero() {
        assertEquals(new BigInteger("1"), App.calculateFactorial(0));
    }
    
    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(new BigInteger("720"), App.calculateFactorial(6));
    }
    
    @Test
    public void testFactorialOfNegativeNumber() {
        try {
            App.calculateFactorial(-5);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Число не может быть отрицательным", e.getMessage());
        }
    }
}
