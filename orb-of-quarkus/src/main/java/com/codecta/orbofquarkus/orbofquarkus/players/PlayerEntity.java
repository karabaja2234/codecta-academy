package com.codecta.orbofquarkus.orbofquarkus.players;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "players",
        indexes = {
                @Index(name = "player_id_index", columnList = "id")
        }
)
public class PlayerEntity extends PlayerAutoMapped {

    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "dungeon_id")
    private DungeonEntity dungeon;
}
