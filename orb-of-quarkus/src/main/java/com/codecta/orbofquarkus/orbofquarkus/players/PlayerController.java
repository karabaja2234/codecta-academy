package com.codecta.orbofquarkus.orbofquarkus.players;

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

    @PutMapping("/players/{id}/heal")
    public ResponseEntity<String> updatePlayersHealth(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.updatePlayersHealth(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Player's health successfully updated!", HttpStatus.OK);
    }

    @PutMapping("/players/{id}/move")
    public ResponseEntity<String> moveToNextDungeon(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.nextDungeon(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Player moved to the next dungeon!", HttpStatus.OK);
    }

    @PutMapping("/players/{id}/goback")
    public ResponseEntity<String> goBackToPreviousDungeon(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.goBack(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Player moved to the previous dungeon!", HttpStatus.OK);
    }
}
