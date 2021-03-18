package com.codecta.orbofquarkus.orbofquarkus.levels;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class LevelMapper {
    public LevelEntity toEntity(LevelDto level) {
        var entity = new LevelEntity();
        BeanUtils.copyProperties(level, entity, LevelEntity.class);
        return entity;
    }

    public LevelDto toDto(LevelEntity entity) {
        var dto = new LevelDto();
        BeanUtils.copyProperties(entity, dto, LevelDto.class);
        return dto;
    }

    public List<LevelDto> toDtoList(Iterable<LevelEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
