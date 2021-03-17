package com.codecta.orbofquarkus.orbofquarkus.maps;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapService {
    private MapRepository mapRepository;

    public Iterable<MapEntity> findAllMaps () {
        return mapRepository.findAll();
    }

    public MapEntity createMap(MapEntity entity) {
        return mapRepository.save(entity);
    }
}
