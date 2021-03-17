package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DungeonAutoMapped {
    private Integer id;
    private Integer mapId;
    private List<MonsterDto> monsters = new ArrayList<>();
    private List<PlayerDto> players = new ArrayList<>();
}
