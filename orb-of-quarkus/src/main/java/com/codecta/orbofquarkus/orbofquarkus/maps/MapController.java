package com.codecta.orbofquarkus.orbofquarkus.maps;

import com.codecta.orbofquarkus.orbofquarkus.players.PlayerDto;
import com.codecta.orbofquarkus.orbofquarkus.players.PlayerEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class MapController {
    private MapRepository mapRepository;
    private MapService mapService;
    private MapMapper mapMapper;

    @GetMapping("/maps")
    private List<MapDto> findAllMaps() {
        Iterable<MapEntity> mapList = mapRepository.findAll();
        if(mapList == null) {
            return null;
        }
        List<MapDto> mapDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(MapEntity map : mapList) {
            mapDtoList.add(modelMapper.map(map, MapDto.class));
        }
        return mapDtoList;
    }

    @PostMapping("/newmap")
    private MapDto createMap(@RequestBody MapDto map) {
        ModelMapper modelMapper = new ModelMapper();
        MapEntity dbMap = modelMapper.map(map, MapEntity.class);
        dbMap = mapRepository.save(dbMap);
        return modelMapper.map(dbMap, MapDto.class);
    }
}
