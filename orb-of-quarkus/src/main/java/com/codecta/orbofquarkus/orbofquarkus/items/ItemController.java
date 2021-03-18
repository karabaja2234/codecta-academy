package com.codecta.orbofquarkus.orbofquarkus.items;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class ItemController {
    private ItemRepository itemRepository;
    private ItemService itemService;

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
    public ResponseEntity<String> createItem(@RequestBody ItemDto item) {
        ItemDto newItem = itemService.createItem(item);
        if(newItem != null) {
            return new ResponseEntity<>("New item added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
