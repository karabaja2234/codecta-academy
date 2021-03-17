package com.codecta.orbofquarkus.orbofquarkus.players;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PlayerMapper {
    public PlayerEntity toEntity(PlayerDto player) {
        var entity = new PlayerEntity();
        BeanUtils.copyProperties(player, entity, PlayerAutoMapped.class);
        return entity;
    }

    public PlayerDto toDto(PlayerEntity entity) {
        var dto = new PlayerDto();
        BeanUtils.copyProperties(entity, dto, PlayerAutoMapped.class);
        return dto;
    }

    public List<PlayerDto> toDtoList(Iterable<PlayerEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
