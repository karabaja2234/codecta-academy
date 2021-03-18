package com.codecta.orbofquarkus.orbofquarkus.items;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Iterable<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity createItem(ItemEntity entity) {
        return itemRepository.save(entity);
    }
}
