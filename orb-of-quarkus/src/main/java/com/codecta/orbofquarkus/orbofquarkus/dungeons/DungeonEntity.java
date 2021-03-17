package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.levels.LevelEntity;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "dungeons",
        indexes = {
                @Index(name = "dungeon_id_index", columnList = "id")
        }
)
public class DungeonEntity extends DungeonAutoMapped{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "dungeon")
    private List<MonsterEntity> monsters;

    @OneToMany(mappedBy = "dungeon")
    private List<PlayerEntity> players;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private MapEntity map;
}
