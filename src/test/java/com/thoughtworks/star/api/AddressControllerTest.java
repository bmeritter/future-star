package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Address;
import com.thoughtworks.star.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AddressControllerTest extends BaseControllerTest {
    @Autowired
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        Account account = Account.builder().username("future_star").password("123456").build();
        accountService.create(account);
    }

    @Test
    public void should_create_address() throws Exception {
        Address address = Address.builder().addressDetail("shanxi").build();

        mockMvc.perform(post("/api/addresses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(address)))
                .andExpect(status().isCreated());

    }

}