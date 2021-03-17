package com.codecta.orbofquarkus.orbofquarkus.players;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class PlayerController {

    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @GetMapping("/players")
    private List<PlayerDto> findAllPlayers() {
        return playerMapper.toDtoList(playerService.findAllPlayers());
    }

    @PostMapping("/newplayer")
    private PlayerDto createPlayer(@RequestBody PlayerDto dto) {
        return playerMapper.toDto(playerService.createPlayer(playerMapper.toEntity(dto)));
    }
}
