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
        name = "MAP",
        indexes = {
                @Index(name = "map_id_index", columnList = "id")
        }
)
public class MapEntity extends MapAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    private List<DungeonEntity> dungeons;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "game_id", nullable=false)
    private GameEntity game;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "level_id", nullable=false)
    private LevelEntity level;
}
