package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DungeonService {
    private DungeonRepository dungeonRepository;

    public Iterable<DungeonEntity> findAllDungeons () {
        return dungeonRepository.findAll();
    }

    public DungeonEntity createDungeon(DungeonEntity entity) {
        return dungeonRepository.save(entity);
    }
}
