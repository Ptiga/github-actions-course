package com.example.calculator;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for calculation results
 */
@Schema(description = "Calculation result")
public class CalculationResult {

    @Schema(description = "First operand", example = "10")
    private double a;

    @Schema(description = "Second operand", example = "5")
    private double b;

    @Schema(description = "Result of the operation", example = "15")
    private double result;

    @Schema(description = "Type of operation performed", example = "add")
    private String operation;

    public CalculationResult(double a, double b, double result, String operation) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.operation = operation;
    }

    // Getters and Setters
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}

