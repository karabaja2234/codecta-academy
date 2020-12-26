package com.codecta.academy.services.model;
import com.codecta.academy.repository.entity.Player;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class GameDto {
    private Integer id;

    private List<Player> players = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
