package com.thoughtworks.star.dto;

public class Account {
    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static Account builder() {
        return new Account();
    }
}
