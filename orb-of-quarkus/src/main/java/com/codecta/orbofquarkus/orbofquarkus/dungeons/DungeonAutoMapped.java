package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerDto;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerEntity;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


public class DungeonAutoMapped {
    private Integer id;
    private Integer mapId;
    private List<MonsterDto> monsters = new ArrayList<>();
    private List<PlayerDto> players = new ArrayList<>();
}
