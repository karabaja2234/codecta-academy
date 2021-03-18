package com.codecta.orbofquarkus.orbofquarkus.players;

import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonEntity;
import com.codecta.orbofquarkus.orbofquarkus.dungeons.DungeonRepository;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemDto;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemEntity;
import com.codecta.orbofquarkus.orbofquarkus.items.ItemRepository;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterDto;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterEntity;
import com.codecta.orbofquarkus.orbofquarkus.monsters.MonsterRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    private DungeonRepository dungeonRepository;
    private ItemRepository itemRepository;
    private MonsterRepository monsterRepository;

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
                    } else return null;
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

    public PlayerDto updatePlayersDamage(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            if(player.getDamageIncreasePotion() != 0) {
                playerToUpdate.setDamage(player.getDamage() + player.getDamageIncreasePotion());
                playerToUpdate.setStatusMessage("Player's damage increased for " + player.getDamageIncreasePotion() + " damaging points!");
                playerToUpdate.setDamageIncreasePotion(0);
            } else {
                playerToUpdate.setStatusMessage("You don't have a damage increasing potion!");
            }
            playerToUpdate = playerRepository.save(playerToUpdate);
            return modelMapper.map(playerToUpdate, PlayerDto.class);
        }
        return null;
    }

    public PlayerDto collectItems(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            DungeonEntity currentDungeon = dungeonRepository.findById(player.getDungeonId()).orElse(null);
            List<MonsterEntity> currentDungeonsMonsters = currentDungeon.getMonsters();
            MonsterEntity currentMonster = null;
            if(currentDungeonsMonsters.size() == 0) {
                return null;
            } else {
                currentMonster = currentDungeonsMonsters.get(0);
                if(currentMonster.getHealth() <= 0) {
                    ItemEntity monstersItem = currentMonster.getItem();
                    ItemEntity itemToUpdate = itemRepository.findById(monstersItem.getId()).orElse(null);
                    if(monstersItem.getName().equals("Healing potion")) {
                        playerToUpdate.setHealingPotion(player.getHealingPotion() + monstersItem.getValue());
                        playerToUpdate.setStatusMessage("Player collected a healing potion!");
                    } else if(monstersItem.getName().equals("Damage increase potion")) {
                        playerToUpdate.setDamageIncreasePotion(player.getDamageIncreasePotion() + monstersItem.getValue());
                        playerToUpdate.setStatusMessage("Player collected a damage increase potion!");
                    } else if(monstersItem.getName().equals("Orb of Quarkus")) {
                        playerToUpdate.setHasOrbOfQuarkus(true);
                        playerToUpdate.setStatusMessage("Congratulations, the Orb of Quarkus is yours!");
                    }
                    itemToUpdate.setValue(0);
                    itemToUpdate = itemRepository.save(itemToUpdate);
                    modelMapper.map(itemToUpdate, ItemDto.class);
                } else {
                    playerToUpdate.setStatusMessage("In order to collect items, you have to kill the monster!");
                }
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }

    public PlayerDto fightMonster(Integer id) {
        PlayerEntity playerToUpdate = playerRepository.findById(id).orElse(null);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            DungeonEntity currentDungeon = dungeonRepository.findById(player.getDungeonId()).orElse(null);
            List<MonsterEntity> currentDungeonsMonsters = currentDungeon.getMonsters();
            MonsterEntity currentMonster = currentDungeonsMonsters.get(0);
            if(currentMonster.getHealth() <= 0) {
                playerToUpdate.setStatusMessage("Monster " + currentMonster.getName() + " has already been killed!");
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            } else {
                Integer playersHealth = player.getHealth();
                Integer playersDamage = player.getDamage();
                Integer monstersHealth = currentMonster.getHealth();
                Integer monstersDamage = currentMonster.getDamage();
                Random rand = new Random();
                while(playersHealth > 0 && monstersHealth > 0) {
                    monstersHealth = monstersHealth - playersDamage*(rand.nextInt(6 - 1 + 1) + 1);
                    playersHealth = playersHealth - monstersDamage*(rand.nextInt(6 - 1 + 1) + 1);
                }

                MonsterEntity monsterToUpdate = monsterRepository.findById(currentMonster.getId()).orElse(null);
                monsterToUpdate.setHealth(monstersHealth);
                modelMapper.map(monsterToUpdate, MonsterDto.class);
                playerToUpdate.setHealth(playersHealth);

                if(playersHealth > 0) {
                    playerToUpdate.setStatusMessage("You have successfully beaten monster " + currentMonster.getName() + "!");
                } else {
                    playerToUpdate.setStatusMessage("Game over!");
                    playerToUpdate.setHealingPotion(0);
                    playerToUpdate.setDamageIncreasePotion(0);
                }
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }
}
