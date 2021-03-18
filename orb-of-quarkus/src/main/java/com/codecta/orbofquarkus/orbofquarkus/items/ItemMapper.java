package com.codecta.orbofquarkus.orbofquarkus.items;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ItemMapper {
    public ItemEntity toEntity(ItemDto item) {
        var entity = new ItemEntity();
        BeanUtils.copyProperties(item, entity, ItemEntity.class);
        return entity;
    }

    public ItemDto toDto(ItemEntity entity) {
        var dto = new ItemDto();
        BeanUtils.copyProperties(entity, dto, ItemDto.class);
        return dto;
    }

    public List<ItemDto> toDtoList(Iterable<ItemEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
