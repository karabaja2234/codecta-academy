package com.codecta.academy.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "codecta", name = "DUNGEON")
public class Dungeon extends  ModelObject{
    @SequenceGenerator(
            name = "dungeonSeq",
            sequenceName = "DUNGEON_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dungeonSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "dungeon", fetch = FetchType.LAZY)
    private List<Monster> monsters = new ArrayList<>();

    @OneToMany(mappedBy = "dungeon", fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();

    @Override
    public Integer getId() {
        return this.id;
    }
}
