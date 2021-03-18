package com.codecta.orbofquarkus.orbofquarkus.monsters;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonDto;
import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonRepository;
import com.codecta.orbofquarkus.orbofquarkus.levels.LevelEntity;
import com.codecta.orbofquarkus.orbofquarkus.levels.LevelRepository;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MonsterService {
    @Autowired
    private MonsterRepository monsterRepository;
    private DungeonRepository dungeonRepository;
    private MapRepository mapRepository;
    private LevelRepository levelRepository;

    public MonsterDto createMonster(MonsterDto monster) {
        if(monster.getDungeonId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        DungeonEntity currentDungeon = dungeonRepository.findById(monster.getDungeonId()).orElse(null);
        DungeonDto dungeon = modelMapper.map(currentDungeon, DungeonDto.class);
        MapEntity currentMap = mapRepository.findById(dungeon.getMapId()).orElse(null);
        MapDto map = modelMapper.map(currentMap, MapDto.class);
        LevelEntity currentLevel = levelRepository.findById(map.getLevelId()).orElse(null);
        monster.setDamage(monster.getDamage()*currentLevel.getDifficulty());
        MonsterEntity dbMonster = modelMapper.map(monster, MonsterEntity.class);
        dbMonster = monsterRepository.save(dbMonster);
        return modelMapper.map(dbMonster, MonsterDto.class);
    }
}
