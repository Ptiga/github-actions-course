package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CalculatorService
 */
@DisplayName("Calculator Service Tests")
public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    // ========== MULTIPLY TESTS ==========
    @Test
    @DisplayName("Test multiplication of positive numbers")
    public void testMultiplyPositiveNumbers() {
        double result = calculatorService.multiply(10, 5);
        assertEquals(50.0, result);
    }

    @Test
    @DisplayName("Test multiplication with negative numbers")
    public void testMultiplyNegativeNumbers() {
        double result = calculatorService.multiply(-10, 5);
        assertEquals(-50.0, result);
    }

    @Test
    @DisplayName("Test multiplication with both negative numbers")
    public void testMultiplyBothNegativeNumbers() {
        double result = calculatorService.multiply(-10, -5);
        assertEquals(50.0, result);
    }

    @Test
    @DisplayName("Test multiplication by zero")
    public void testMultiplyByZero() {
        double result = calculatorService.multiply(10, 0);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Test multiplication with decimal numbers")
    public void testMultiplyDecimalNumbers() {
        double result = calculatorService.multiply(2.5, 4.0);
        assertEquals(10.0, result);
    }

    // ========== DIVIDE TESTS ==========
    @Test
    @DisplayName("Test division of positive numbers")
    public void testDividePositiveNumbers() {
        double result = calculatorService.divide(20, 4);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test division with negative dividend")
    public void testDivideNegativeDividend() {
        double result = calculatorService.divide(-20, 4);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Test division with negative divisor")
    public void testDivideNegativeDivisor() {
        double result = calculatorService.divide(20, -4);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Test division with both negative numbers")
    public void testDivideBothNegativeNumbers() {
        double result = calculatorService.divide(-20, -4);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test division by zero throws exception")
    public void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(10, 0);
        });
    }

    @Test
    @DisplayName("Test division with decimal numbers")
    public void testDivideDecimalNumbers() {
        double result = calculatorService.divide(10.0, 2.5);
        assertEquals(4.0, result);
    }

    // ========== ADD TESTS ==========
    @Test
    @DisplayName("Test addition of positive numbers")
    public void testAddPositiveNumbers() {
        double result = calculatorService.add(10, 5);
        assertEquals(15.0, result);
    }

    @Test
    @DisplayName("Test addition with negative numbers")
    public void testAddNegativeNumbers() {
        double result = calculatorService.add(-10, 5);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Test addition with both negative numbers")
    public void testAddBothNegativeNumbers() {
        double result = calculatorService.add(-10, -5);
        assertEquals(-15.0, result);
    }

    @Test
    @DisplayName("Test addition with zero")
    public void testAddWithZero() {
        double result = calculatorService.add(10, 0);
        assertEquals(10.0, result);
    }

    @Test
    @DisplayName("Test addition with decimal numbers")
    public void testAddDecimalNumbers() {
        double result = calculatorService.add(2.5, 3.5);
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("Test addition of zero and zero")
    public void testAddZeroAndZero() {
        double result = calculatorService.add(0, 0);
        assertEquals(0.0, result);
    }

    // ========== SUBTRACT TESTS ==========
    @Test
    @DisplayName("Test subtraction of positive numbers")
    public void testSubtractPositiveNumbers() {
        double result = calculatorService.subtract(10, 5);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test subtraction with negative result")
    public void testSubtractNegativeResult() {
        double result = calculatorService.subtract(5, 10);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Test subtraction with negative first number")
    public void testSubtractNegativeFirstNumber() {
        double result = calculatorService.subtract(-10, 5);
        assertEquals(-15.0, result);
    }

    @Test
    @DisplayName("Test subtraction with negative second number")
    public void testSubtractNegativeSecondNumber() {
        double result = calculatorService.subtract(10, -5);
        assertEquals(15.0, result);
    }

    @Test
    @DisplayName("Test subtraction with both negative numbers")
    public void testSubtractBothNegativeNumbers() {
        double result = calculatorService.subtract(-10, -5);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Test subtraction with zero")
    public void testSubtractWithZero() {
        double result = calculatorService.subtract(10, 0);
        assertEquals(10.0, result);
    }

    @Test
    @DisplayName("Test subtraction with decimal numbers")
    public void testSubtractDecimalNumbers() {
        double result = calculatorService.subtract(10.5, 3.5);
        assertEquals(7.0, result);
    }

    @Test
    @DisplayName("Test subtraction of same numbers")
    public void testSubtractSameNumbers() {
        double result = calculatorService.subtract(10, 10);
        assertEquals(0.0, result);
    }

}

