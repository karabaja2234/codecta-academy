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

    @ManyToOne
    private Game game;


    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    @Override
    public Integer getId() {
        return this.id;
    }
}
