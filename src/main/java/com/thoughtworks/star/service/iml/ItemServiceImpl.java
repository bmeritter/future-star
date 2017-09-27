package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.repository.ItemRepository;
import com.thoughtworks.star.service.ItemService;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public void create(Item item) {
        item.setId(StringUtil.randomUUID());
        itemRepository.save(item);
    }

    @Override
    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }
}
