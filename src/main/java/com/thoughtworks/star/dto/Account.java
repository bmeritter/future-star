package com.thoughtworks.star.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Set<Order> orders;

}
