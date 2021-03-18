package com.codecta.orbofquarkus.orbofquarkus.monsters;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemEntity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(
        name = "MONSTER",
        indexes = {
                @Index(name = "monster_id_index", columnList = "id")
        }
)
public class MonsterEntity {
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
    @JoinColumn(name="item_id")
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name="dungeon_id")
    private DungeonEntity dungeon;
}
