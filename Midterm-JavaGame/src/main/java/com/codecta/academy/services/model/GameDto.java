package com.codecta.academy.services.model;

import java.util.ArrayList;
import java.util.List;

public class GameDto {
    private Integer id;
    private List<MapDto> maps = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MapDto> getMaps() {
        return maps;
    }

    public void setMaps(List<MapDto> maps) {
        this.maps = maps;
    }
}
