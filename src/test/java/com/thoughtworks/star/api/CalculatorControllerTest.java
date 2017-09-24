package com.thoughtworks.star.api;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CalculatorControllerTest extends BaseControllerTest {

    @Test
    public void should_return_letters_length_string() throws Exception {
        mockMvc.perform(get("/api/letters-counts").param("letters", "aababbbcabcdabcde"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("5(a)<6(b)<3(c)<2(d)<1(e)"));

    }

}