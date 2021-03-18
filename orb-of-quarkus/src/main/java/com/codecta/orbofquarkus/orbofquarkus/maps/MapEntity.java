package com.codecta.orbofquarkus.orbofquarkus.maps;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.games.GameEntity;
import com.codecta.orbofquarkus.orbofquarkus.levels.LevelEntity;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerEntity;
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
public class MapEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "map",fetch= FetchType.LAZY)
    private List<DungeonEntity> dungeons = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name="level_id")
    private LevelEntity level;
}
