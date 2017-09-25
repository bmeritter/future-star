package com.thoughtworks.star.dto;

import lombok.*;

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
    private String name;
    private Integer price;
}
