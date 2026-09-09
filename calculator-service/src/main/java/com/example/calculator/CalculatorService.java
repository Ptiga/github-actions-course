package com.example.calculator;

import org.springframework.stereotype.Service;

/**
 * Service for basic arithmetic operations
 */
@Service
public class CalculatorService {

    /**
     * Multiplies two numbers
     *
     * @param a first number
     * @param b second number
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides first number by second number
     *
     * @param a dividend (first number)
     * @param b divisor (second number)
     * @return the quotient a / b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    /**
     * Adds two numbers
     *
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts second number from first number
     *
     * @param a first number
     * @param b second number
     * @return the difference a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

}

