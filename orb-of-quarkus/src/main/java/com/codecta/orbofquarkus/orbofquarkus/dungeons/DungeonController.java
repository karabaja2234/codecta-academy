package com.codecta.orbofquarkus.orbofquarkus.dungeons;

import com.codecta.orbofquarkus.orbofquarkus.games.GameDto;
import com.codecta.orbofquarkus.orbofquarkus.games.GameEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class DungeonController {
    private DungeonRepository dungeonRepository;
    private DungeonService dungeonService;
    private DungeonMapper dungeonMapper;

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
    private DungeonDto createDungeon(@RequestBody DungeonDto dungeon) {
        ModelMapper modelMapper = new ModelMapper();
        DungeonEntity dbDungeon = modelMapper.map(dungeon, DungeonEntity.class);
        dbDungeon = dungeonRepository.save(dbDungeon);
        return modelMapper.map(dbDungeon, DungeonDto.class);
    }
}
