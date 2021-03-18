package com.codecta.orbofquarkus.orbofquarkus.maps;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class MapController {
    private MapRepository mapRepository;
    private MapService mapService;

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
    public ResponseEntity<String> createMap(@RequestBody MapDto map) {
        MapDto newMap = mapService.createMap(map);
        if(newMap != null) {
            return new ResponseEntity<>("New map added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
