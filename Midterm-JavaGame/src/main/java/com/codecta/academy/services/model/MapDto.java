package com.codecta.academy.services.model;

import com.codecta.academy.repository.entity.Dungeon;
import java.util.ArrayList;
import java.util.List;

public class MapDto {
    private Integer id;
    private List<Dungeon> dungeons = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Dungeon> getDungeons() {
        return dungeons;
    }

    public void setDungeons(List<Dungeon> dungeons) {
        this.dungeons = dungeons;
    }
}
