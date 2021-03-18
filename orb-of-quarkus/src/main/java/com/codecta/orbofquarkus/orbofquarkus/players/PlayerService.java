package com.codecta.orbofquarkus.orbofquarkus.players;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonRepository;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    private DungeonRepository dungeonRepository;

    public Iterable<PlayerEntity> findAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerEntity createPlayer(PlayerEntity entity) {
        return playerRepository.save(entity);
    }

    public PlayerDto updatePlayersHealth(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            if(player.getHealingPotion() != 0) {
                playerToUpdate.setHealth(player.getHealth() + player.getHealingPotion());
                playerToUpdate.setStatusMessage("Player healed for " + player.getHealingPotion() + " healing points!");
                playerToUpdate.setHealingPotion(0);
            } else {
                playerToUpdate.setStatusMessage("You don't have a healing potion!");
            }
            playerToUpdate = playerRepository.save(playerToUpdate);
            return modelMapper.map(playerToUpdate, PlayerDto.class);
        }
        return null;
    }

    public PlayerDto nextDungeon(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            DungeonEntity currentDungeon = dungeonRepository.findById(player.getDungeonId()).orElse(null);
            List<MonsterEntity> currentDungeonsMonsters = currentDungeon.getMonsters();
            DungeonEntity nextDungeon = dungeonRepository.findById(player.getDungeonId() + 1).orElse(null);
            if(nextDungeon != null) {
                if(currentDungeonsMonsters.size() > 0) {
                    if(currentDungeonsMonsters.get(0).getHealth() <= 0) {
                        playerToUpdate.setDungeon(nextDungeon);
                        playerToUpdate.setStatusMessage("Player moved to dungeon " + nextDungeon.getId() + "!");
                        playerToUpdate = playerRepository.save(playerToUpdate);
                        return modelMapper.map(playerToUpdate, PlayerDto.class);
                    }
                }
                playerToUpdate.setDungeon(nextDungeon);
                playerToUpdate.setStatusMessage("Player moved to dungeon " + nextDungeon.getId() + "!");
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }

    public PlayerDto goBack(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            DungeonEntity previousDungeon = dungeonRepository.findById(player.getDungeonId() - 1).orElse(null);
            if(previousDungeon != null) {
                playerToUpdate.setDungeon(previousDungeon);
                playerToUpdate.setStatusMessage("Player moved to dungeon " + previousDungeon.getId() + "!");
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }
}
