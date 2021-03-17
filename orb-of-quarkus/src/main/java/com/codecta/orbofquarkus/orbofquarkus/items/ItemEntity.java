package com.codecta.orbofquarkus.orbofquarkus.items;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "ITEM",
        indexes = {
                @Index(name = "item_id_index", columnList = "id")
        }
)
public class ItemEntity extends ItemAutoMapped {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<MonsterEntity> monsters;
}
