package com.codecta.orbofquarkus.orbofquarkus.maps;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.games.GameEntity;
import com.codecta.orbofquarkus.orbofquarkus.levels.LevelEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
        name = "maps",
        indexes = {
                @Index(name = "map_id_index", columnList = "id")
        }
)
public class MapEntity extends MapAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "map")
    private List<DungeonEntity> dungeons;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private LevelEntity level;
}
