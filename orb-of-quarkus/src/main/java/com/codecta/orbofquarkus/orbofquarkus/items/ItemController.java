package com.codecta.orbofquarkus.orbofquarkus.items;

import com.codecta.orbofquarkus.orbofquarkus.levels.LevelDto;
import com.codecta.orbofquarkus.orbofquarkus.levels.LevelEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class ItemController {
    private ItemRepository itemRepository;
    private ItemService itemService;
    private ItemMapper itemMapper;

    @GetMapping("/items")
    private List<ItemDto> findAllItems() {
        Iterable<ItemEntity> itemList = itemRepository.findAll();
        if(itemList == null) {
            return null;
        }
        List<ItemDto> itemDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(ItemEntity item : itemList) {
            itemDtoList.add(modelMapper.map(item, ItemDto.class));
        }
        return itemDtoList;
    }

    @PostMapping("/newitem")
    private ItemDto createItem(@RequestBody ItemDto item) {
        ModelMapper modelMapper = new ModelMapper();
        ItemEntity dbItem = modelMapper.map(item, ItemEntity.class);
        dbItem = itemRepository.save(dbItem);
        return modelMapper.map(dbItem, ItemDto.class);
    }
}
