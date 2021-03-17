package com.codecta.orbofquarkus.orbofquarkus.players;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "players",
        indexes = {
                @Index(name = "id_index", columnList = "id")
        }
)
public class PlayerEntity extends PlayerAutoMapped {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "health")
    private Integer health;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "healing_potion")
    private Integer healingPotion;

    @Column(name = "damage_increase_potion")
    private Integer damageIncreasePotion;

    @Column(name = "name")
    private String name;

    @Column(name = "has_orb_of_quarkus")
    private Boolean hasOrbOfQuarkus;

    @Column(name = "status_message")
    private String statusMessage;
}
