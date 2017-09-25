package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Address;
import com.thoughtworks.star.repository.AddressRepository;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void save(Address address) {
        address.setId(StringUtil.randomUUID());

        addressRepository.save(address);

    }
}
