package com.thoughtworks.star.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_shopping_cart")
public class ShoppingCart {
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Account account;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "t_shopping_cart_item", joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> items;
}
