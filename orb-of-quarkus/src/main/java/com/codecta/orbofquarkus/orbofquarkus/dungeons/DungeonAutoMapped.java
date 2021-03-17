package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DungeonAutoMapped {
    private Integer id;
    private Integer mapId;
    //private List<MonsterAutoMapped> monsters = new ArrayList<>();
    //private List<PlayerAutoMapped> players = new ArrayList<>();
}
