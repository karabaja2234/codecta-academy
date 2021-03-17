package com.codecta.orbofquarkus.orbofquarkus.maps;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class MapAutoMapped {
    private Integer id;
    private Integer gameId;
    private Integer levelId;
    private List<DungeonDto> dungeons = new ArrayList<>();
}
