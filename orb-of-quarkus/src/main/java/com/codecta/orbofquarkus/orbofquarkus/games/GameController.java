package com.codecta.orbofquarkus.orbofquarkus.games;

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
public class GameController {
    private GameRepository gameRepository;
    private GameService gameService;

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
    public ResponseEntity<String> createGame(@RequestBody GameDto game) {
        GameDto newGame = gameService.createGame(game);
        if(newGame != null) {
            return new ResponseEntity<>("New game added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }
}
