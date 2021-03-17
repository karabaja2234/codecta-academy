package com.codecta.orbofquarkus.orbofquarkus.maps;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.games.GameEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
        name = "maps",
        indexes = {
                @Index(name = "id_index", columnList = "id")
        }
)
public class MapEntity extends MapAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "maps", fetch= FetchType.LAZY)
    private List<DungeonEntity> dungeons = new ArrayList<>();

    @ManyToOne
    private GameEntity game;
}
