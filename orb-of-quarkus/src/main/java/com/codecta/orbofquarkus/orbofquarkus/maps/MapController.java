package com.codecta.orbofquarkus.orbofquarkus.maps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class MapController {
    private MapService mapService;
    private MapMapper mapMapper;

    @GetMapping("/maps")
    private List<MapDto> findAllMaps() {
        return mapMapper.toDtoList(mapService.findAllMaps());
    }

    @PostMapping("/newmap")
    private MapDto createMap(@RequestBody MapDto dto) {
        return mapMapper.toDto(mapService.createMap(mapMapper.toEntity(dto)));
    }
}
