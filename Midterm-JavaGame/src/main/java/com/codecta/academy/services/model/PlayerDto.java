package com.codecta.academy.services.model;

public class PlayerDto {
    private Integer id;
    private Integer health;
    private Integer damage;
    private Integer healingPotion;
    private String name;
    private Boolean hasOrbOfQuarkus;
    private Integer dungeonId;
    private String statusMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHealingPotion() {
        return healingPotion;
    }

    public void setHealingPotion(Integer healingPotion) {
        this.healingPotion = healingPotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasOrbOfQuarkus() {
        return hasOrbOfQuarkus;
    }

    public void setHasOrbOfQuarkus(Boolean hasOrbOfQuarkus) {
        this.hasOrbOfQuarkus = hasOrbOfQuarkus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Integer getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(Integer dungeonId) {
        this.dungeonId = dungeonId;
    }
}
