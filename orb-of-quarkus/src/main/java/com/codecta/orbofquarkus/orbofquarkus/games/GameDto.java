package com.codecta.orbofquarkus.orbofquarkus.games;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class GameDto {
    private Integer id;
    private List<MapDto> maps = new ArrayList<>();
}
