package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.ItemService;
import com.thoughtworks.star.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShoppingCartControllerTest extends BaseControllerTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    private Account account;

    @BeforeEach
    void setUp() {
        account = Account.builder().age(12).username("future_star").password("123456").build();
        accountService.create(account);
    }

    @Test
    public void should_add_item_to_shopping_cart() throws Exception {
        Item item = Item.builder().price(3).name("item 3").build();

        mockMvc.perform(post("/api/shopping-cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(item)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_shopping_cart_by_username() throws Exception {
        Item item = Item.builder().name("item 7").price(1).build();
        itemService.create(item);

        List<Item> items = new ArrayList<>();
        items.add(item);

        shoppingCartService.create(item);

        mockMvc.perform(get("/api/shopping-cart")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.account").isNotEmpty())
                .andExpect(jsonPath("$.items").isNotEmpty());
    }
}