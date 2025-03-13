package com.kodilla.testing.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Rozpoczynam testy...");

        Calculator calculator = new Calculator();

        // Test dodawania
        int sumResult = calculator.add(10, 5);
        if (sumResult == 15) {
            System.out.println("Test dodawania OK");
        } else {
            System.out.println("Błąd! Oczekiwano 15, otrzymano: " + sumResult);
        }

        // Test odejmowania
        int subtractResult = calculator.subtract(10, 5);
        if (subtractResult == 5) {
            System.out.println("Test odejmowania OK");
        } else {
            System.out.println("Błąd! Oczekiwano 5, otrzymano: " + subtractResult);
        }
    }
}
