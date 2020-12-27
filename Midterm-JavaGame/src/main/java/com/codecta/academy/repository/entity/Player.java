package com.codecta.academy.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "codecta", name = "PLAYER")
public class Player extends  ModelObject{
    @SequenceGenerator(
            name = "playerSeq",
            sequenceName = "PLAYER_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    private Integer health;
    private Integer damage;
    private Integer healingPotion;
    private String name;
    private Boolean hasOrbOfQuarkus;
    private String statusMessage;

    @Override
    public Integer getId() {
        return this.id;
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

    @ManyToOne
    private Dungeon dungeon;

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
}
