package com.codecta.orbofquarkus.orbofquarkus.games;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GameMapper {
    public GameEntity toEntity(GameDto game) {
        var entity = new GameEntity();
        BeanUtils.copyProperties(game, entity, GameEntity.class);
        return entity;
    }

    public GameDto toDto(GameEntity entity) {
        var dto = new GameDto();
        BeanUtils.copyProperties(entity, dto, GameDto.class);
        return dto;
    }

    public List<GameDto> toDtoList(Iterable<GameEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
