package com.codecta.orbofquarkus.orbofquarkus.games;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
        name = "games",
        indexes = {
                @Index(name = "game_id_index", columnList = "id")
        }
)
public class GameEntity extends GameAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "game")
    private List<MapEntity> maps;
}
