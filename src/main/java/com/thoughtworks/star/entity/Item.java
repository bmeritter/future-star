package com.thoughtworks.star.entity;

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
@Table(name = "t_item")
public class Item {

    @Id
    private String id;

    @Column(unique = true)
    private String name;
    private Integer price;

}
