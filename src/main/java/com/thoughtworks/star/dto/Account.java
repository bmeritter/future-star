package com.thoughtworks.star.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_account")
public class Account {

    @Id
    private String id;

    private String username;

    private String password;
    private Integer age;

}
