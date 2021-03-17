package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DungeonMapper {
    public DungeonEntity toEntity(DungeonDto game) {
        var entity = new DungeonEntity();
        BeanUtils.copyProperties(game, entity, DungeonAutoMapped.class);
        return entity;
    }

    public DungeonDto toDto(DungeonEntity entity) {
        var dto = new DungeonDto();
        BeanUtils.copyProperties(entity, dto, DungeonAutoMapped.class);
        return dto;
    }

    public List<DungeonDto> toDtoList(Iterable<DungeonEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
