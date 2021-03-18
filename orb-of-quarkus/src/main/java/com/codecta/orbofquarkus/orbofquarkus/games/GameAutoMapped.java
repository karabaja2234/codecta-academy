package com.codecta.orbofquarkus.orbofquarkus.games;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapAutoMapped;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


public class GameAutoMapped {
    private Integer id;
    private List<MapDto> maps = new ArrayList<>();
}
