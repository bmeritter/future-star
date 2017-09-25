package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShoppingCartControllerTest extends BaseControllerTest {

    @Autowired
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        Account account = Account.builder().age(12).username("future_star").password("123456").build();
        accountService.save(account);
    }

    @Test
    public void should_add_to_shopping_cart() throws Exception {
        Item item = Item.builder().price(3).name("item 3").build();
        String username = "future_star";

        mockMvc.perform(post("/api/shopping-cart").param("username", username)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(item)))
                .andExpect(status().isOk());


    }

}