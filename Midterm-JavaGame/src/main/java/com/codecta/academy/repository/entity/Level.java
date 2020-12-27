package com.codecta.academy.repository.entity;

import javax.persistence.*;

@Entity
@Table(schema = "codecta", name = "LEVEL")
public class Level extends  ModelObject{
    @SequenceGenerator(
            name = "levelSeq",
            sequenceName = "LEVEL_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "levelSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    private Integer difficulty;

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @ManyToOne
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
