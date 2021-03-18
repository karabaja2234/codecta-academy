package com.codecta.orbofquarkus.orbofquarkus.levels;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class LevelController {
    private LevelRepository levelRepository;
    private LevelService levelService;
    private LevelMapper levelMapper;

    @GetMapping("/levels")
    private List<LevelDto> findAllLevels() {
        Iterable<LevelEntity> levelList = levelRepository.findAll();
        if(levelList == null) {
            return null;
        }
        List<LevelDto> levelDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(LevelEntity level : levelList) {
            levelDtoList.add(modelMapper.map(level, LevelDto.class));
        }
        return levelDtoList;
    }

    @PostMapping("/newlevel")
    private LevelDto createLevel(@RequestBody LevelDto level) {
        ModelMapper modelMapper = new ModelMapper();
        LevelEntity dbLevel = modelMapper.map(level, LevelEntity.class);
        dbLevel = levelRepository.save(dbLevel);
        return modelMapper.map(dbLevel, LevelDto.class);
    }
}
