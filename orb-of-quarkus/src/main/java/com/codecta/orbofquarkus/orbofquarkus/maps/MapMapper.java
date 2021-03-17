package com.codecta.orbofquarkus.orbofquarkus.maps;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MapMapper {
    public MapEntity toEntity(MapDto map) {
        var entity = new MapEntity();
        BeanUtils.copyProperties(map, entity, MapAutoMapped.class);
        return entity;
    }

    public MapDto toDto(MapEntity entity) {
        var dto = new MapDto();
        BeanUtils.copyProperties(entity, dto, MapAutoMapped.class);
        return dto;
    }

    public List<MapDto> toDtoList(Iterable<MapEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
