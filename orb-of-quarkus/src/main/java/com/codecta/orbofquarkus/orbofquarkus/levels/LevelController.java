package com.codecta.orbofquarkus.orbofquarkus.levels;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class LevelController {
    private LevelService levelService;
    private LevelMapper levelMapper;

    @GetMapping("/levels")
    private List<LevelDto> findAllLevels() {
        return levelMapper.toDtoList(levelService.findAllLevels());
    }

    @PostMapping("/newlevel")
    private LevelDto createLevel(@RequestBody LevelDto dto) {
        return levelMapper.toDto(levelService.createLevel(levelMapper.toEntity(dto)));
    }
}
