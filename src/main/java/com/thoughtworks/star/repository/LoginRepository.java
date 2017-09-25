package com.thoughtworks.star.repository;

import com.thoughtworks.star.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Account, String> {

    Account findOneByUsernameAndPassword(String username, String password);
}
