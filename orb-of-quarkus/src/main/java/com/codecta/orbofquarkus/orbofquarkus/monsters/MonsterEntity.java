package com.codecta.orbofquarkus.orbofquarkus.monsters;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(
        name = "monsters",
        indexes = {
                @Index(name = "id_index", columnList = "id")
        }
)
public class MonsterEntity extends MonsterAutoMapped{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "health")
    private Integer health;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private ItemEntity item;

    @ManyToOne
    private DungeonEntity dungeon;
}
