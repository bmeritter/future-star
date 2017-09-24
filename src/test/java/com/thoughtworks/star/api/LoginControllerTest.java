package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LoginControllerTest extends BaseControllerTest {

    @Test
    public void test_for_login_api() throws Exception {

        Account account = Account.builder().username("future_star").password("123456").build();

        mockMvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("login success"));
    }
}