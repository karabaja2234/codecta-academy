package com.codecta.orbofquarkus.orbofquarkus.items;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public ItemDto createItem(ItemDto item) {
        ModelMapper modelMapper = new ModelMapper();
        ItemEntity dbItem = modelMapper.map(item, ItemEntity.class);
        dbItem = itemRepository.save(dbItem);
        return modelMapper.map(dbItem,ItemDto.class);
    }
}
