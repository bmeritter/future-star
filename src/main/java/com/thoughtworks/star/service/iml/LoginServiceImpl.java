package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.repository.LoginRepository;
import com.thoughtworks.star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean login(Account account) {
        return loginRepository.findAccountByUsername(account.getUsername()).getPassword().equals(account.getPassword());
    }
}
