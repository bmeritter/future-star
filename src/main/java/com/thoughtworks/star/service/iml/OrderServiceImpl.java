package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Address;
import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.Order;
import com.thoughtworks.star.repository.AccountRepository;
import com.thoughtworks.star.repository.OrderRepository;
import com.thoughtworks.star.service.OrderService;
import com.thoughtworks.star.util.SessionCache;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void create(List<Item> items) {
        String currentAccount = sessionCache.fetchCurrentAccount();
        Account account = accountRepository.findAccountByUsername(currentAccount);

        Address address = account.getAddresses().get(0);

        Order order = Order.builder().id(StringUtil.randomUUID()).address(address).items(items).build();

        List<Order> orders = Arrays.asList(order);
        if (account.getOrders() != null) {
            orders.addAll(account.getOrders());
        }

        account.setOrders(orders);

        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
