package com.thoughtworks.star.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Account {
    private String username;
    private String password;
    private Integer age;

}
