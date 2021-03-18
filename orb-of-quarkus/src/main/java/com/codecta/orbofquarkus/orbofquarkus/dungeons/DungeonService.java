package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DungeonService {
    @Autowired
    private DungeonRepository dungeonRepository;

    public Iterable<DungeonEntity> findAllDungeons () {
        return dungeonRepository.findAll();
    }

    public DungeonEntity createDungeon(DungeonEntity entity) {
        return dungeonRepository.save(entity);
    }
}
