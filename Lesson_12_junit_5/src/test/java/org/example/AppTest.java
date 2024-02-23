package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {
    
    @Test
    void testFactorialOfZero() {
        assertEquals(new BigInteger("1"), App.calculateFactorial(0));
    }
    
    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(new BigInteger("720"), App.calculateFactorial(6));
    }
    
    @Test
    void testFactorialOfNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> App.calculateFactorial(-5));
        assertEquals("Число не может быть отрицательным", exception.getMessage());
    }
}
