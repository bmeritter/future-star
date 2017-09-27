package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.Order;
import com.thoughtworks.star.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody List<Item> items) {
        orderService.create(items);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAll() {
        return orderService.findAll();
    }
}
