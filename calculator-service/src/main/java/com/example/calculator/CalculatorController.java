package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller for calculator operations
 * Provides endpoints for basic arithmetic operations
 */
@RestController
@RequestMapping("/api/calculator")
@Tag(name = "Calculator", description = "API for basic arithmetic operations")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    /**
     * Multiply two numbers
     *
     * @param a first number
     * @param b second number
     * @return the product
     */
    @GetMapping("/multiply")
    @Operation(summary = "Multiply two numbers", description = "Multiplies two numbers and returns the result")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculationResult.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    public ResponseEntity<CalculationResult> multiply(
            @Parameter(description = "First number", example = "10")
            @RequestParam(value = "a") double a,
            @Parameter(description = "Second number", example = "5")
            @RequestParam(value = "b") double b) {
        double result = calculatorService.multiply(a, b);
        return ResponseEntity.ok(new CalculationResult(a, b, result, "multiply"));
    }

    /**
     * Divide first number by second number
     *
     * @param a dividend
     * @param b divisor
     * @return the quotient
     */
    @GetMapping("/divide")
    @Operation(summary = "Divide two numbers", description = "Divides first number by second number and returns the result")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculationResult.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or division by zero")
    })
    public ResponseEntity<?> divide(
            @Parameter(description = "Dividend (first number)", example = "20")
            @RequestParam(value = "a") double a,
            @Parameter(description = "Divisor (second number)", example = "4")
            @RequestParam(value = "b") double b) {
        try {
            double result = calculatorService.divide(a, b);
            return ResponseEntity.ok(new CalculationResult(a, b, result, "divide"));
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    /**
     * Add two numbers
     *
     * @param a first number
     * @param b second number
     * @return the sum
     */
    @GetMapping("/add")
    @Operation(summary = "Add two numbers", description = "Adds two numbers and returns the result")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculationResult.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    public ResponseEntity<CalculationResult> add(
            @Parameter(description = "First number", example = "10")
            @RequestParam(value = "a") double a,
            @Parameter(description = "Second number", example = "5")
            @RequestParam(value = "b") double b) {
        double result = calculatorService.add(a, b);
        return ResponseEntity.ok(new CalculationResult(a, b, result, "add"));
    }

    /**
     * Subtract second number from first number
     *
     * @param a first number
     * @param b second number
     * @return the difference
     */
    @GetMapping("/subtract")
    @Operation(summary = "Subtract two numbers", description = "Subtracts second number from first number and returns the result")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculationResult.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    public ResponseEntity<CalculationResult> subtract(
            @Parameter(description = "First number", example = "10")
            @RequestParam(value = "a") double a,
            @Parameter(description = "Second number", example = "3")
            @RequestParam(value = "b") double b) {
        double result = calculatorService.subtract(a, b);
        return ResponseEntity.ok(new CalculationResult(a, b, result, "subtract"));
    }

}

