package com.codecta.academy.services.model;

public class PlayerDto {
    private Integer id;
    private String name;
    private Integer health;
    private Integer damage;
    private Integer healingPotion;
    private Integer gameId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
