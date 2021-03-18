package com.codecta.orbofquarkus.orbofquarkus.dungeons;

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
        name = "DUNGEON",
        indexes = {
                @Index(name = "dungeon_id_index", columnList = "id")
        }
)
public class DungeonEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "dungeon", fetch= FetchType.LAZY)
    private List<MonsterEntity> monsters = new ArrayList<>();

    @OneToMany(mappedBy = "dungeon", fetch= FetchType.LAZY)
    private List<PlayerEntity> players = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="map_id")
    private MapEntity map;
}
