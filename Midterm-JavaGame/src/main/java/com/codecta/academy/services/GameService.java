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
    List<ItemDto> findAllItems();
    List<MonsterDto> findAllMonsters();

    PlayerDto updatePlayersHealth(Integer id);
    PlayerDto updatePlayersDungeon(Integer id);
    PlayerDto updatePlayersDamage(Integer id);
    PlayerDto collectItems(Integer id);
    PlayerDto fightMonster(Integer id, PlayerDto player);

    MonsterDto updateMonstersHealth(Integer id, MonsterDto monster);

    /*
    PlayerDto findPlayerById(Integer id);
    PlayerDto updatePlayer(Integer id, PlayerDto player);
    GameDto findGameById(Integer id);
    GameDto updateGame(Integer id, GameDto game);
    List<GameDto> findGameByPlayerName(String name);
    List<PlayerDto> findPlayerByGameId(Integer id);
    */
}
