package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Address;
import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.AddressService;
import com.thoughtworks.star.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTest extends BaseControllerTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        Account account = Account.builder().age(12).username("future_star").password("123456").build();
        accountService.create(account);

        Address address = Address.builder().addressDetail("PK").build();
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        account.setAddresses(addresses);

        addressService.create(address);
    }

    @Test
    public void should_create_order() throws Exception {
        Item item = Item.builder().price(2).name("item 9").build();
        itemService.create(item);

        List<Item> items = new ArrayList<>();
        items.add(item);

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(items)))
                .andExpect(status().isCreated());
    }
}
