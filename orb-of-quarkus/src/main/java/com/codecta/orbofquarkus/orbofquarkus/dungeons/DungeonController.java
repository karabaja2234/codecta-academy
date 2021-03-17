package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class DungeonController {
    private DungeonService dungeonService;
    private DungeonMapper dungeonMapper;

    @GetMapping("/dungeons")
    private List<DungeonDto> findAllDungeons() {
        return dungeonMapper.toDtoList(dungeonService.findAllDungeons());
    }

    @PostMapping("/newdungeon")
    private DungeonDto createDungeon(@RequestBody DungeonDto dto) {
        return dungeonMapper.toDto(dungeonService.createDungeon(dungeonMapper.toEntity(dto)));
    }
}
