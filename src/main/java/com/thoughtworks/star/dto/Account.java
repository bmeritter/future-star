package com.thoughtworks.star.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class Account {

    @Id
    private String id;

    @Column(unique = true)
    private String username;

    private String password;
    private Integer age;

}
