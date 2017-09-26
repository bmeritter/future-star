package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LoginControllerTest extends BaseControllerTest {
    @Autowired
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        Account account = Account.builder().id(StringUtil.randomUUID()).username("future_star").password("123456").build();
        accountService.save(account);

    }

    @Test
    public void test_for_login_api() throws Exception {

        Account account = Account.builder().username("future_star").password("123456").build();

        mockMvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("login success"));
    }
}