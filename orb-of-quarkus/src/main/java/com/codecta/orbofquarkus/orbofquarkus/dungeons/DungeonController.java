package com.codecta.orbofquarkus.orbofquarkus.dungeons;

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
public class DungeonController {
    private DungeonRepository dungeonRepository;
    private DungeonService dungeonService;

    @GetMapping("/dungeons")
    private List<DungeonDto> findAllDungeons() {
        Iterable<DungeonEntity> dungeonList = dungeonRepository.findAll();
        if(dungeonList == null) {
            return null;
        }
        List<DungeonDto> dungeonDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(DungeonEntity dungeon : dungeonList) {
            dungeonDtoList.add(modelMapper.map(dungeon, DungeonDto.class));
        }
        return dungeonDtoList;
    }

    @PostMapping("/newdungeon")
    public ResponseEntity<String> createDungeon(@RequestBody DungeonDto dungeon) {
        DungeonDto newDungeon = dungeonService.createDungeon(dungeon);
        if(newDungeon != null) {
            return new ResponseEntity<>("New dungeon added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
