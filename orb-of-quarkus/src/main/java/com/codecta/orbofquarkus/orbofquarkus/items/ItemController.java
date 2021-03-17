package com.codecta.orbofquarkus.orbofquarkus.items;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class ItemController {
    private ItemService itemService;
    private ItemMapper itemMapper;

    @GetMapping("/items")
    private List<ItemDto> findAllItems() {
        return itemMapper.toDtoList(itemService.findAllItems());
    }

    @PostMapping("/newitem")
    private ItemDto createItem(@RequestBody ItemDto dto) {
        return itemMapper.toDto(itemService.createItem(itemMapper.toEntity(dto)));
    }
}
