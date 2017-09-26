package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Address;
import com.thoughtworks.star.repository.AddressRepository;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public void save(String username, Address address) {

        Account account = accountService.findOneByUsername(username);

        address.setId(StringUtil.randomUUID());

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);

        account.setAddresses(addresses);

        if (account != null) {
            addressRepository.save(address);
        }
    }
}
