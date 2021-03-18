package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DungeonService {
    @Autowired
    private DungeonRepository dungeonRepository;

    public DungeonDto createDungeon(DungeonDto dungeon) {
        if(dungeon.getMapId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        DungeonEntity dbDungeon = modelMapper.map(dungeon, DungeonEntity.class);
        dbDungeon = dungeonRepository.save(dbDungeon);
        return modelMapper.map(dbDungeon,DungeonDto.class);
    }
}
