package com.codecta.orbofquarkus.orbofquarkus.items;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    public Iterable<ItemEntity> findAllItems () {
        return itemRepository.findAll();
    }

    public ItemEntity createItem(ItemEntity entity) {
        return itemRepository.save(entity);
    }
}
