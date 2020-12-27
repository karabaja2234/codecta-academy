package com.codecta.academy.services.model;

import com.codecta.academy.repository.entity.Dungeon;
import java.util.ArrayList;
import java.util.List;

public class MapDto {
    private Integer id;
    private Integer gameId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
