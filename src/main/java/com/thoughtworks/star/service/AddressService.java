package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Address;

public interface AddressService {
    void save(String username, Address address);
}
