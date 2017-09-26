package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Address;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.Order;
import com.thoughtworks.star.repository.AccountRepository;
import com.thoughtworks.star.repository.OrderRepository;
import com.thoughtworks.star.service.OrderService;
import com.thoughtworks.star.util.SessionCache;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(Set<Item> items) {
        String currentAccount = sessionCache.fetchCurrentAccount();

        if (currentAccount.equals("")) {
            return;
        }
        Account account = accountRepository.findAccountByUsername(currentAccount);

        List<Address> set = account.getAddresses();

        Address address = set.get(0);

        Order order = Order.builder().id(StringUtil.randomUUID()).address(address).items(items).build();


        Set<Order> orders = new HashSet<>();
        orders.add(order);
        account.setOrders(orders);

        orderRepository.save(order);
        accountRepository.save(account);
    }
}
