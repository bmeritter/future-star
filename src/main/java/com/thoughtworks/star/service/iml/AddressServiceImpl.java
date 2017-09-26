package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Address;
import com.thoughtworks.star.repository.AddressRepository;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.AddressService;
import com.thoughtworks.star.util.SessionCache;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SessionCache sessionCache;

    @Override
    public void save(Address address) {
        String currentAccount = sessionCache.fetchCurrentAccount();

        if (currentAccount.equals("")) {
            return;
        }

        Account account = accountService.findOneByUsername(currentAccount);

        address.setId(StringUtil.randomUUID());

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        account.setAddresses(addresses);

        addressRepository.save(address);

        accountService.save(account);
        System.out.println(account);
        System.out.println("============");
    }
}