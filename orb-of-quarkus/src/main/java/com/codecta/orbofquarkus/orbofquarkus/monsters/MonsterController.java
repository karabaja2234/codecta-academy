package com.codecta.orbofquarkus.orbofquarkus.monsters;

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
public class MonsterController {
    private MonsterRepository monsterRepository;
    private MonsterService monsterService;
    private MonsterMapper monsterMapper;

    @GetMapping("/monsters")
    private List<MonsterDto> findAllMonsters() {
        Iterable<MonsterEntity> monsterList = monsterRepository.findAll();
        if(monsterList == null) {
            return null;
        }
        List<MonsterDto> monsterDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(MonsterEntity monster : monsterList) {
            monsterDtoList.add(modelMapper.map(monster, MonsterDto.class));
        }
        return monsterDtoList;
    }

    @PostMapping("/newmonster")
    private MonsterDto createMonster(@RequestBody MonsterDto monster) {
        ModelMapper modelMapper = new ModelMapper();
        MonsterEntity dbMonster = modelMapper.map(monster, MonsterEntity.class);
        dbMonster = monsterRepository.save(dbMonster);
        return modelMapper.map(dbMonster, MonsterDto.class);
    }
}
