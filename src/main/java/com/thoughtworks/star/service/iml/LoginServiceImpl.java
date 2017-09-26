package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.dto.Account;
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
        if(loginRepository.findOneByUsernameAndPassword(account.getUsername(), account.getPassword())== null){
            return false;
        }
        return true;
    }
}
