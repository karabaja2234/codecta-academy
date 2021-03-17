package com.codecta.orbofquarkus.orbofquarkus.levels;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(
        name = "LEVEL",
        indexes = {
                @Index(name = "level_id_index", columnList = "id")
        }
)
public class LevelEntity extends LevelAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "difficulty")
    private Integer difficulty;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<MapEntity> maps;
}
