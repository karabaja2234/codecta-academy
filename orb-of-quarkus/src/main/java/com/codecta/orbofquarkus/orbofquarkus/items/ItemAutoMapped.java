package com.codecta.orbofquarkus.orbofquarkus.items;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


public class ItemAutoMapped {
    private Integer id;
    private Integer value;
    private String name;
    private List<MonsterDto> monsters = new ArrayList<>();
}
