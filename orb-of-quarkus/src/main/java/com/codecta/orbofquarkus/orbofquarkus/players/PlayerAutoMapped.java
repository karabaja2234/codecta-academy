package com.codecta.orbofquarkus.orbofquarkus.players;

import lombok.Data;

@Data
public class PlayerAutoMapped {
    private Integer id;
    private Integer health;
    private Integer damage;
    private Integer healingPotion;
    private Integer damageIncreasePotion;
    private String name;
    private Boolean hasOrbOfQuarkus;
    private String statusMessage;
    private Integer dungeonId;
}
