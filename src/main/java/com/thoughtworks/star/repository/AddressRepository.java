package com.thoughtworks.star.repository;

import com.thoughtworks.star.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
