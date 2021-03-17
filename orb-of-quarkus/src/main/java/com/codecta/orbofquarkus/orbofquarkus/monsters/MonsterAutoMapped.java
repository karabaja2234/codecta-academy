package com.codecta.orbofquarkus.orbofquarkus.monsters;

import lombok.Data;

@Data
public class MonsterAutoMapped {
    private Integer id;
    private Integer health;
    private Integer damage;
    private String name;
    private Integer dungeonId;
    private Integer itemId;
}
