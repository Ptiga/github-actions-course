package com.example.calculator;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for error responses
 */
@Schema(description = "Error response")
public class ErrorResponse {

    @Schema(description = "Error message", example = "Division by zero is not allowed")
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

