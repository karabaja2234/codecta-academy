package com.codecta.orbofquarkus.orbofquarkus.monsters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class MonsterController {
    private MonsterService monsterService;
    private MonsterMapper monsterMapper;

    @GetMapping("/monsters")
    private List<MonsterDto> findAllMonsters() {
        return monsterMapper.toDtoList(monsterService.findAllMonsters());
    }

    @PostMapping("/newmonster")
    private MonsterDto createMonster(@RequestBody MonsterDto dto) {
        return monsterMapper.toDto(monsterService.createMonster(monsterMapper.toEntity(dto)));
    }
}
