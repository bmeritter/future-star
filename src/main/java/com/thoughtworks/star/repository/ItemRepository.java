package com.thoughtworks.star.repository;

import com.thoughtworks.star.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
