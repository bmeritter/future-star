package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.util.StringUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest extends BaseControllerTest {


    @Test
    public void should_create_account() throws Exception {
        Account account = Account.builder().username("future_star").password("123456").age(22).build();

        mockMvc.perform(post("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("future_star"));
    }

    @Test
    public void should_return_account_list() throws Exception {
        Account account = Account.builder().username("future_star").password("1").age(22).build();
        AccountCache.add(account);
        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk());
    }

    @Disabled
    @Test
    public void should_update_age() throws Exception {
        AccountCache.clear();

        Account account = Account.builder().username("future_star").password("1").age(22).build();

        AccountCache.add(account);
        Account updatedAccount = Account.builder().username("future_star").password("1").age(3).build();
        AccountCache.add(updatedAccount);

        mockMvc.perform(put("/api/accounts/" + account.getUsername())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedAccount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("update age success"));
    }

    @Test
    public void should_return_accounts_by_age() throws Exception {
        AccountCache.clear();

        AccountCache.add(Account.builder().username("future_st").password("1").age(22).build());
        AccountCache.add(Account.builder().username("future_sta").password("1").age(2).build());
        AccountCache.add(Account.builder().username("future_star").password("1").age(22).build());

        mockMvc.perform(get("/api/accounts").param("age", "22"))
                .andExpect(status().isOk());
    }
}