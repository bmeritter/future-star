package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.repository.AccountRepository;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public Account create(Account account) {
        account.setId(StringUtil.randomUUID());
        return accountRepository.save(account);
    }

    @Override
    public String updateAge(String username, Account account) {
        return null;
    }

    @Override
    public List<Map.Entry<String, Account>> getAccountByAge(int age) {
        return null;
    }

    @Override
    public Account findOneByUsername(String username) {

        return accountRepository.findAccountByUsername(username);
    }
}
