package com.codecta.orbofquarkus.orbofquarkus.players;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("players")
public class PlayerController {

    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @GetMapping
    private List<PlayerDto> findAllPlayers() {
        return playerMapper.toDtoList(playerService.findAllPlayers());
    }

    @PostMapping
    private PlayerDto createUser(@RequestBody PlayerDto dto) {
        return playerMapper.toDto(playerService.createPlayer(playerMapper.toEntity(dto)));
    }
}
