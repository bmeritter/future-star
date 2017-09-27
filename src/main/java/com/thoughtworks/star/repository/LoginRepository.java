package com.thoughtworks.star.repository;

import com.thoughtworks.star.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Account, String> {
    Account findAccountByUsername(String username);
}
