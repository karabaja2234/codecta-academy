package com.codecta.orbofquarkus.orbofquarkus.levels;

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
public class LevelController {
    private LevelRepository levelRepository;
    private LevelService levelService;

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
    public ResponseEntity<String> createLevel(@RequestBody LevelDto level) {
        LevelDto newLevel = levelService.createLevel(level);
        if(newLevel != null) {
            return new ResponseEntity<>("New level added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
