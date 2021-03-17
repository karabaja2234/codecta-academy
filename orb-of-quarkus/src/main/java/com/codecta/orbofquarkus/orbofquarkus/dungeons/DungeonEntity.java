package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(
        name = "DUNGEON",
        indexes = {
                @Index(name = "dungeon_id_index", columnList = "id")
        }
)
public class DungeonEntity extends DungeonAutoMapped{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "dungeon", cascade = CascadeType.ALL)
    private List<MonsterEntity> monsters;

    @OneToMany(mappedBy = "dungeon", cascade = CascadeType.ALL)
    private List<PlayerEntity> players;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "map_id", nullable=false)
    private MapEntity map;
}
