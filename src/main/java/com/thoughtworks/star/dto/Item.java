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
@Table(name = "t_item")
public class Item {

    @Id
    private String id;

    @Column(unique = true)
    private String name;
    private Integer price;

}
