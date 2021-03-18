package com.codecta.orbofquarkus.orbofquarkus.levels;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


public class LevelAutoMapped {
    private Integer id;
    private Integer difficulty;
    private List<MapDto> maps = new ArrayList<>();
}
