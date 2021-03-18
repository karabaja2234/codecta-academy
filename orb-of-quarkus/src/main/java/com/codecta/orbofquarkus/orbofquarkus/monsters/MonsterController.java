package com.codecta.orbofquarkus.orbofquarkus.monsters;

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
public class MonsterController {
    private MonsterRepository monsterRepository;
    private MonsterService monsterService;

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
    public ResponseEntity<String> createMonster(@RequestBody MonsterDto monster) {
        MonsterDto newMonster = monsterService.createMonster(monster);
        if(newMonster != null) {
            return new ResponseEntity<>("New monster added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
