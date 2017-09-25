package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.repository.ItemRepository;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        item.setId(StringUtil.randomUUID());
        itemRepository.save(item);
    }

    @Override
    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }
}
