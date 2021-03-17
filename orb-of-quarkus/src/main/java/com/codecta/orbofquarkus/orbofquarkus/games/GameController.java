package com.codecta.orbofquarkus.orbofquarkus.games;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class GameController {
    private GameService gameService;
    private GameMapper gameMapper;

    @GetMapping("/games")
    private List<GameDto> findAllGames() {
        return gameMapper.toDtoList(gameService.findAllGames());
    }

    @PostMapping("/newgame")
    private GameDto createGame(@RequestBody GameDto dto) {
        return gameMapper.toDto(gameService.createGame(gameMapper.toEntity(dto)));
    }
}
