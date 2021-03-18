package com.codecta.orbofquarkus.orbofquarkus.maps;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapService {
    @Autowired
    private MapRepository mapRepository;

    public MapDto createMap(MapDto map) {
        if(map.getGameId() == null || map.getLevelId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        MapEntity dbMap = modelMapper.map(map, MapEntity.class);
        dbMap = mapRepository.save(dbMap);
        return modelMapper.map(dbMap,MapDto.class);
    }
}
