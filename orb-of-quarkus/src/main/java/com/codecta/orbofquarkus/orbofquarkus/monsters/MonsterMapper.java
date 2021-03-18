package com.codecta.orbofquarkus.orbofquarkus.monsters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MonsterMapper {
    public MonsterEntity toEntity(MonsterDto monster) {
        var entity = new MonsterEntity();
        BeanUtils.copyProperties(monster, entity, MonsterEntity.class);
        return entity;
    }

    public MonsterDto toDto(MonsterEntity entity) {
        var dto = new MonsterDto();
        BeanUtils.copyProperties(entity, dto, MonsterDto.class);
        return dto;
    }

    public List<MonsterDto> toDtoList(Iterable<MonsterEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
