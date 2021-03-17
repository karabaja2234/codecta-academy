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
        name = "dungeons",
        indexes = {
                @Index(name = "id_index", columnList = "id")
        }
)
public class DungeonEntity extends DungeonAutoMapped{
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "dungeon",fetch= FetchType.LAZY)
    private List<MonsterEntity> monsters = new ArrayList<>();

    @OneToMany(mappedBy = "dungeon",fetch= FetchType.LAZY)
    private List<PlayerEntity> players = new ArrayList<>();

    @ManyToOne
    private MapEntity map;
}
