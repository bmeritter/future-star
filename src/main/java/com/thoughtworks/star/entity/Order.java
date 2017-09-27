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
@Table(name = "t_order")
public class Order {
    @Id
    private String id;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "t_order_items", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> items;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Address address;

}
