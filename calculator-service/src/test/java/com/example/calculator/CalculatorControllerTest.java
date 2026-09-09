package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Integration tests for CalculatorController
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Calculator Controller Tests")
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ========== MULTIPLY TESTS ==========
    @Test
    @DisplayName("Test multiply endpoint with valid parameters")
    public void testMultiplyEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/multiply")
                .param("a", "10")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(50.0))
                .andExpect(jsonPath("$.operation").value("multiply"));
    }

    @Test
    @DisplayName("Test multiply with decimal numbers")
    public void testMultiplyWithDecimals() throws Exception {
        mockMvc.perform(get("/api/calculator/multiply")
                .param("a", "2.5")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10.0));
    }

    // ========== DIVIDE TESTS ==========
    @Test
    @DisplayName("Test divide endpoint with valid parameters")
    public void testDivideEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "20")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0))
                .andExpect(jsonPath("$.operation").value("divide"));
    }

    @Test
    @DisplayName("Test divide by zero returns error")
    public void testDivideByZeroReturnsError() throws Exception {
        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "10")
                .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Division by zero is not allowed"));
    }

    // ========== ADD TESTS ==========
    @Test
    @DisplayName("Test add endpoint with valid parameters")
    public void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/add")
                .param("a", "10")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15.0))
                .andExpect(jsonPath("$.operation").value("add"));
    }

    @Test
    @DisplayName("Test add with negative numbers")
    public void testAddWithNegatives() throws Exception {
        mockMvc.perform(get("/api/calculator/add")
                .param("a", "-10")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-5.0));
    }

    // ========== SUBTRACT TESTS ==========
    @Test
    @DisplayName("Test subtract endpoint with valid parameters")
    public void testSubtractEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/subtract")
                .param("a", "10")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(7.0))
                .andExpect(jsonPath("$.operation").value("subtract"));
    }

    @Test
    @DisplayName("Test subtract with negative result")
    public void testSubtractNegativeResult() throws Exception {
        mockMvc.perform(get("/api/calculator/subtract")
                .param("a", "5")
                .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-5.0));
    }

    @Test
    @DisplayName("Test missing parameters returns error")
    public void testMissingParameters() throws Exception {
        mockMvc.perform(get("/api/calculator/add")
                .param("a", "10"))
                .andExpect(status().isBadRequest());
    }

}

