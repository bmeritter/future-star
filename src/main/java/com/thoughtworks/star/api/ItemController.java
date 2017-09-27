package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Item item) {
        itemService.create(item);
        return item.getName();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Item> getAll() {
        return itemService.findAll();
    }
}
