package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest extends BaseControllerTest {
    @Test
    public void should_create_account() throws Exception {
        Account account = Account.builder().username("future_star").password("1").age(22).build();

        mockMvc.perform(post("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("create success"));
    }

    @Test
    public void should_return_account_list() throws Exception {
        Account account = Account.builder().username("future_star").password("1").age(22).build();
        AccountCache.accounts.put("future_star", account);
        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void should_update_age() throws Exception {
        Account account = Account.builder().username("future_star").password("1").age(22).build();
        AccountCache.accounts.put("future_star", account);

        Account newAccount = Account.builder().username("future_star").password("1").age(3).build();

        mockMvc.perform(put("/api/accounts/" + account.getUsername())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newAccount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("update age success"));
    }

    @Test
    public void should_return_accounts_by_age() throws Exception {
        Account accountOne = Account.builder().username("future_st").password("1").age(22).build();
        Account accountTwo = Account.builder().username("future_sta").password("1").age(2).build();
        Account accountThree = Account.builder().username("future_star").password("1").age(22).build();

        AccountCache.accounts.put(accountOne.getUsername(), accountOne);
        AccountCache.accounts.put(accountTwo.getUsername(), accountTwo);
        AccountCache.accounts.put(accountThree.getUsername(), accountThree);

        mockMvc.perform(get("/api/accounts").param("age", "22"))
                .andExpect(status().isOk());
    }
}