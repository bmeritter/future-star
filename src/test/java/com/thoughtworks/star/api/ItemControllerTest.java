package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.service.ItemService;
import com.thoughtworks.star.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ItemControllerTest extends BaseControllerTest {

    @Autowired
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemService.save(Item.builder().name("item 1").price(1).id(StringUtil.randomUUID()).build());
    }

    @Test
    public void should_return_all_items() throws Exception {

        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].price").value(1))
                .andExpect(jsonPath("$[0].name  ").value("item 1"));
    }

}