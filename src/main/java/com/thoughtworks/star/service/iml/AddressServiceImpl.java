package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Address;
import com.thoughtworks.star.repository.AccountRepository;
import com.thoughtworks.star.repository.AddressRepository;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.AddressService;
import com.thoughtworks.star.util.SessionCache;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SessionCache sessionCache;


    @Override
    @Transactional
    public void create(Address address) {
        String currentAccount = sessionCache.fetchCurrentAccount();
        Account account = accountService.findOneByUsername(currentAccount);

        address.setId(StringUtil.randomUUID());

        List<Address> addresses = Arrays.asList(address);

        if (account.getAddresses() != null) {
            addresses.addAll(account.getAddresses());
        }

        account.setAddresses(addresses);

        addressRepository.save(address);
    }
}
