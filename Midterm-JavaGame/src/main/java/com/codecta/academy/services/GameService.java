package com.codecta.academy.services;

import com.codecta.academy.repository.entity.WelcomeMessage;
import com.codecta.academy.services.model.*;

import java.util.List;

public interface GameService {
    WelcomeMessage welcome();

    //Methods for adding instances of entities
    GameDto addGame(GameDto game);
    LevelDto addLevel(LevelDto level);
    MapDto addMap(MapDto map);
    DungeonDto addDungeon(DungeonDto dungeon);
    PlayerDto addPlayer(PlayerDto player);
    ItemDto addItem(ItemDto item);
    MonsterDto addMonster(MonsterDto monster);

    //Methods for reading all instances
    List<GameDto> findAllGames();
    List<LevelDto> findAllLevels();
    List<MapDto> findAllMaps();
    List<DungeonDto> findAllDungeons();
    List<PlayerDto> findAllPlayers();
    PlayerDto findPlayerById(Integer id);
    List<ItemDto> findAllItems();
    List<MonsterDto> findAllMonsters();

    //Methods for updating information about players and monsters
    PlayerDto updatePlayersHealth(Integer id);
    PlayerDto nextDungeon(Integer id);
    PlayerDto goBack(Integer id);
    PlayerDto updatePlayersDamage(Integer id);
    PlayerDto collectItems(Integer id);
    PlayerDto fightMonster(Integer id);
}
