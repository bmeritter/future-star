package com.thoughtworks.star.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(unique = true)
    private String username;

    private String password;
    private Integer age;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_id")
    private List<Order> orders;

}