package com.codecta.orbofquarkus.orbofquarkus.items;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemDto {
    private Integer id;
    private Integer value;
    private String name;
    private List<MonsterDto> monsters = new ArrayList<>();
}
