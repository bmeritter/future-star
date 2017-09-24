package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(1)));

    }


}