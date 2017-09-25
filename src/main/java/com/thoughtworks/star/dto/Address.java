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
@Table(name = "t_address")
public class Address {

    @Id
    private String id;
    private String addressDetail;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
