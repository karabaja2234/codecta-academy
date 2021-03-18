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
    public ResponseEntity<String> createPlayer(@RequestBody PlayerDto player)
    {
        PlayerDto newPlayer = playerService.createPlayer(player);
        if(newPlayer != null) {
            return new ResponseEntity<>("New player added!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/players/{id}/heal")
    public ResponseEntity<String> updatePlayersHealth(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.updatePlayersHealth(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.OK);
    }

    @PutMapping("/players/{id}/move")
    public ResponseEntity<String> moveToNextDungeon(@PathVariable Integer id) {
        PlayerEntity originalPlayer = playerRepository.findById(id).orElse(null);
        PlayerDto updatedPlayer = playerService.nextDungeon(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        } else if(originalPlayer.getDungeon().getId() == updatedPlayer.getDungeonId()) {
            return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Player moved to the next dungeon!", HttpStatus.OK);
    }

    @PutMapping("/players/{id}/goback")
    public ResponseEntity<String> goBackToPreviousDungeon(@PathVariable Integer id) {
        PlayerEntity originalPlayer = playerRepository.findById(id).orElse(null);
        PlayerDto updatedPlayer = playerService.goBack(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        } else if(originalPlayer.getDungeon().getId() == updatedPlayer.getDungeonId()) {
            return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Player moved to the previous dungeon!", HttpStatus.OK);
    }

    @PutMapping("/players/{id}/stronger")
    public ResponseEntity<String> updatePlayersDamage(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.updatePlayersDamage(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.OK);
    }

    @PutMapping("/players/{id}/collect")
    public ResponseEntity<String> collectPlayersItems(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.collectItems(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.OK);
    }

    @PutMapping("/players/{id}/fight")
    public ResponseEntity<String> fightMonster(@PathVariable Integer id) {
        PlayerDto updatedPlayer = playerService.fightMonster(id);
        if(updatedPlayer == null) {
            return new ResponseEntity<>("Player not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPlayer.getStatusMessage(), HttpStatus.OK);
    }
}
