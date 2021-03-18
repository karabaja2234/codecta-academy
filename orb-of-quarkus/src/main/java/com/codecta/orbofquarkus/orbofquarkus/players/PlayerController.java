package com.codecta.orbofquarkus.orbofquarkus.players;

import com.codecta.orbofquarkus.orbofquarkus.maps.MapDto;
import com.codecta.orbofquarkus.orbofquarkus.maps.MapEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("game")
public class PlayerController {

    private PlayerRepository playerRepository;
    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @GetMapping("/players")
    private List<PlayerDto> findAllPlayers() {
        Iterable<PlayerEntity> playerList = playerRepository.findAll();
        if(playerList == null) {
            return null;
        }
        List<PlayerDto> playerDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(PlayerEntity player : playerList) {
            playerDtoList.add(modelMapper.map(player, PlayerDto.class));
        }
        return playerDtoList;
    }

    @PostMapping("/newplayer")
    private PlayerDto createPlayer(@RequestBody PlayerDto player) {
        ModelMapper modelMapper = new ModelMapper();
        PlayerEntity dbPlayer = modelMapper.map(player, PlayerEntity.class);
        dbPlayer = playerRepository.save(dbPlayer);
        return modelMapper.map(dbPlayer, PlayerDto.class);
    }
}
