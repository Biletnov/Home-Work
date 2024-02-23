package org.example;

import java.math.BigInteger;

//Создайте 2 ветки: Lesson_12_junit_5 и Lesson_12_testng.
//
//Напишите программу, позволяющую вычислить факториал числа. Эта программа должна быть в каждой ветке.
//
//В ветке Lesson_12_junit_5 напишите юнит-тесты для этой программы, используя Junit 5.
//
//В ветке Lesson_12_testng  напишите юнит-тесты, используя TestNG.

public class App {
    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(calculateFactorial(10));
    }
}