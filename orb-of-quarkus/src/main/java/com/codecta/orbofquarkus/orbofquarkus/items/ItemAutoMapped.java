package com.codecta.orbofquarkus.orbofquarkus.items;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ItemAutoMapped {
    private Integer id;
    private Integer value;
    private String name;
    //private List<MonsterAutoMapped> monsters = new ArrayList<>();
}
