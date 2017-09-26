package com.thoughtworks.star.util;

import org.springframework.stereotype.Component;

@Component
public class SessionCache {

    public static String currentAccount = "future_star";

    public static void setCurrentAccount(String currentAccount) {
        currentAccount = currentAccount;
    }

    public String fetchCurrentAccount() {
        return currentAccount;
    }
}
