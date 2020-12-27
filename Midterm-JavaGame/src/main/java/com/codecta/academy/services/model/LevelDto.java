package com.codecta.academy.services.model;

import java.util.ArrayList;
import java.util.List;

public class LevelDto {
    private Integer id;
    private Integer difficulty;
    private List<MapDto> maps = new ArrayList<>();

    public Integer getId() {
        return id;
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

    public List<MapDto> getMaps() {
        return maps;
    }

    public void setMaps(List<MapDto> maps) {
        this.maps = maps;
    }
}
