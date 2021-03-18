package com.codecta.orbofquarkus.orbofquarkus.games;

import com.codecta.orbofquarkus.orbofquarkus.items.ItemDto;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class GameController {
    private GameRepository gameRepository;
    private GameService gameService;
    private GameMapper gameMapper;

    @GetMapping("/games")
    private List<GameDto> findAllGames() {
        Iterable<GameEntity> gameList = gameRepository.findAll();
        if(gameList == null) {
            return null;
        }
        List<GameDto> gameDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(GameEntity game : gameList) {
            gameDtoList.add(modelMapper.map(game, GameDto.class));
        }
        return gameDtoList;
    }

    @PostMapping("/newgame")
    private GameDto createGame(@RequestBody GameDto game) {
        ModelMapper modelMapper = new ModelMapper();
        GameEntity dbGame = modelMapper.map(game, GameEntity.class);
        dbGame = gameRepository.save(dbGame);
        return modelMapper.map(dbGame, GameDto.class);
    }
}
