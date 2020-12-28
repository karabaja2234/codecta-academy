package com.codecta.academy.services.impl;

import com.codecta.academy.repository.*;
import com.codecta.academy.repository.entity.*;
import com.codecta.academy.services.GameService;
import com.codecta.academy.services.model.*;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
@Transactional
public class GameServiceImpl implements GameService {

    @Inject
    PlayerRepository playerRepository;

    @Inject
    GameRepository gameRepository;

    @Inject
    MapRepository mapRepository;

    @Inject
    LevelRepository levelRepository;

    @Inject
    DungeonRepository dungeonRepository;

    @Inject
    ItemRepository itemRepository;

    @Inject
    MonsterRepository monsterRepository;

    @Override
    public WelcomeMessage welcome() {
        return new WelcomeMessage("Welcome to the game!", "Here you can find....", "Everyday from 8 am to 10 pm");
    }

    @Override
    public GameDto addGame(GameDto game) {
        ModelMapper modelMapper = new ModelMapper();
        Game dbGame = modelMapper.map(game, Game.class);
        dbGame = gameRepository.add(dbGame);
        return modelMapper.map(dbGame,GameDto.class);
    }

    @Override
    public MapDto addMap(MapDto map) {
        if(map.getGameId() == null || map.getLevelId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Map dbMap = modelMapper.map(map, Map.class);
        dbMap = mapRepository.add(dbMap);
        return modelMapper.map(dbMap,MapDto.class);
    }

    @Override
    public LevelDto addLevel(LevelDto level) {
        ModelMapper modelMapper = new ModelMapper();
        Level dbLevel = modelMapper.map(level, Level.class);
        dbLevel = levelRepository.add(dbLevel);
        return modelMapper.map(dbLevel,LevelDto.class);
    }

    @Override
    public DungeonDto addDungeon(DungeonDto dungeon) {
        if(dungeon.getMapId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Dungeon dbDungeon = modelMapper.map(dungeon, Dungeon.class);
        dbDungeon = dungeonRepository.add(dbDungeon);
        return modelMapper.map(dbDungeon,DungeonDto.class);
    }

    @Override
    public PlayerDto addPlayer(PlayerDto player) {
        if(player.getDungeonId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Player dbPlayer = modelMapper.map(player, Player.class);
        dbPlayer = playerRepository.add(dbPlayer);
        return modelMapper.map(dbPlayer,PlayerDto.class);
    }

    @Override
    public ItemDto addItem(ItemDto item) {
        ModelMapper modelMapper = new ModelMapper();
        Item dbItem = modelMapper.map(item, Item.class);
        dbItem = itemRepository.add(dbItem);
        return modelMapper.map(dbItem,ItemDto.class);
    }

    @Override
    public MonsterDto addMonster(MonsterDto monster) {
        if(monster.getDungeonId() == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Monster dbMonster = modelMapper.map(monster, Monster.class);
        dbMonster = monsterRepository.add(dbMonster);
        return modelMapper.map(dbMonster,MonsterDto.class);
    }

    @Override
    public List<GameDto> findAllGames() {
        List<Game> games = gameRepository.findAll();
        if(games == null || games.isEmpty()) {
            return  null;
        }
        List<GameDto> gameDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Game game : games) {
            GameDto gameDto = modelMapper.map(game, GameDto.class);
            gameDtoList.add(gameDto);
        }
        return gameDtoList;
    }

    @Override
    public List<LevelDto> findAllLevels() {
        List<Level> levels = levelRepository.findAll();
        if(levels == null || levels.isEmpty()) {
            return  null;
        }
        List<LevelDto> levelDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Level level : levels) {
            LevelDto levelDto = modelMapper.map(level, LevelDto.class);
            levelDtoList.add(levelDto);
        }
        return levelDtoList;
    }

    @Override
    public List<MapDto> findAllMaps() {
        List<Map> maps = mapRepository.findAll();
        if(maps == null || maps.isEmpty()) {
            return  null;
        }
        List<MapDto> mapDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Map map : maps) {
            MapDto mapDto = modelMapper.map(map, MapDto.class);
            mapDtoList.add(mapDto);
        }
        return mapDtoList;
    }

    @Override
    public List<DungeonDto> findAllDungeons() {
        List<Dungeon> dungeons = dungeonRepository.findAll();
        if(dungeons == null || dungeons.isEmpty()) {
            return  null;
        }
        List<DungeonDto> dungeonDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Dungeon dungeon : dungeons) {
            DungeonDto dungeonDto = modelMapper.map(dungeon, DungeonDto.class);
            dungeonDtoList.add(dungeonDto);
        }
        return dungeonDtoList;
    }

    @Override
    public List<PlayerDto> findAllPlayers() {

        List<Player> playerList = playerRepository.findAll();
        if(playerList == null || playerList.isEmpty()) {
            return null;
        }
        List<PlayerDto> playerDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Player player : playerList) {
            playerDtoList.add(modelMapper.map(player, PlayerDto.class));
        }
        return playerDtoList;
    }

    @Override
    public List<ItemDto> findAllItems() {

        List<Item> itemList = itemRepository.findAll();
        if(itemList == null || itemList.isEmpty()) {
            return null;
        }
        List<ItemDto> itemDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Item item : itemList) {
            itemDtoList.add(modelMapper.map(item, ItemDto.class));
        }
        return itemDtoList;
    }

    @Override
    public List<MonsterDto> findAllMonsters() {

        List<Monster> monsterList = monsterRepository.findAll();
        if(monsterList == null || monsterList.isEmpty()) {
            return null;
        }
        List<MonsterDto> monsterDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Monster monster : monsterList) {
            monsterDtoList.add(modelMapper.map(monster, MonsterDto.class));
        }
        return monsterDtoList;
    }

    @Override
    public PlayerDto updatePlayersHealth(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
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

    @Override
    public PlayerDto nextDungeon(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            Dungeon currentDungeon = dungeonRepository.findById(player.getDungeonId());
            List<Monster> currentDungeonsMonsters = currentDungeon.getMonsters();
            Dungeon nextDungeon = dungeonRepository.findById(player.getDungeonId() + 1);
            if(currentDungeonsMonsters.get(0).getHealth() <= 0) {
                if(nextDungeon != null) {
                    playerToUpdate.setDungeon(nextDungeon);
                    playerToUpdate.setStatusMessage("Player moved to dungeon " + nextDungeon.getId() + "!");
                    playerToUpdate = playerRepository.save(playerToUpdate);
                    return modelMapper.map(playerToUpdate, PlayerDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public PlayerDto goBack(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            Dungeon previousDungeon = dungeonRepository.findById(player.getDungeonId() - 1);
            if(previousDungeon != null) {
                playerToUpdate.setDungeon(previousDungeon);
                playerToUpdate.setStatusMessage("Player moved to dungeon " + previousDungeon.getId() + "!");
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }

    @Override
    public PlayerDto updatePlayersDamage(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
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

    @Override
    public PlayerDto collectItems(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            Dungeon currentDungeon = dungeonRepository.findById(player.getDungeonId());
            List<Monster> currentDungeonsMonsters = currentDungeon.getMonsters();
            Monster currentMonster = currentDungeonsMonsters.get(0);
            if(currentMonster.getHealth() <= 0) {
                Item monstersItem = currentMonster.getItem();
                Item itemToUpdate = itemRepository.findById(monstersItem.getId());
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
        return null;
    }

    @Override
    public PlayerDto fightMonster(Integer id) {
        Player playerToUpdate = playerRepository.findById(id);
        if(playerToUpdate != null) {
            ModelMapper modelMapper = new ModelMapper();
            PlayerDto player = modelMapper.map(playerToUpdate, PlayerDto.class);
            Dungeon currentDungeon = dungeonRepository.findById(player.getDungeonId());
            List<Monster> currentDungeonsMonsters = currentDungeon.getMonsters();
            Monster currentMonster = currentDungeonsMonsters.get(0);
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

                Monster monsterToUpdate = monsterRepository.findById(currentMonster.getId());
                monsterToUpdate.setHealth(monstersHealth);
                modelMapper.map(monsterToUpdate, MonsterDto.class);
                playerToUpdate.setHealth(playersHealth);

                if(playersHealth > 0) {
                    playerToUpdate.setStatusMessage("You have successfully beaten monster " + currentMonster.getName() + "!");
                } else {
                    playerToUpdate.setStatusMessage("Game over!");
                    playerToUpdate.setHealingPotion(0);
                    playerToUpdate.setDamageIncreasePotion(0);
                    playerToUpdate.setDungeon(dungeonRepository.findById(1));
                }
                playerToUpdate = playerRepository.save(playerToUpdate);
                return modelMapper.map(playerToUpdate, PlayerDto.class);
            }
        }
        return null;
    }

    @Override
    public PlayerDto findPlayerById(Integer id) {
        Player player = playerRepository.findById(id);
        if(player == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(player, PlayerDto.class);
    }
    /*
    @Override
    public PlayerDto findPlayerById(Integer id) {
        Player player = playerRepository.findById(id);
        if(player == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(player, PlayerDto.class);
    }

    @Override
    public PlayerDto updatePlayer(Integer id, PlayerDto player) {
        Player playerToUpdate = playerRepository.findById(id);
        if(playerToUpdate != null) {
            playerToUpdate.setName(player.getName());
            playerToUpdate = playerRepository.save(playerToUpdate);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(playerToUpdate, PlayerDto.class);
        }
        return null;
    }

    @Override
    public GameDto findGameById(Integer id) {
        Game game = gameRepository.findById(id);
        if(game == null) {
            return  null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(game, GameDto.class);
    }

    @Override
    public GameDto updateGame(Integer id, GameDto game) {
        Game dbGame = gameRepository.findById(id);
        if (dbGame != null) {
            //dbGame.setPlayers(game.getPlayers());
            dbGame = gameRepository.save(dbGame);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(dbGame, GameDto.class);
        }
        return null;
    }


    @Override
    public List<PlayerDto> findPlayerByGameId(Integer id) {
        List<Player> playerList = playerRepository.findAllByGameId(id);
        if(playerList == null || playerList.isEmpty()) {
            return null;
        }
        List<PlayerDto> playerDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Player player : playerList) {
            playerDtoList.add(modelMapper.map(player, PlayerDto.class));
        }
        return playerDtoList;
    }

    @Override
    public List<GameDto> findGameByPlayerName(String name) {
        List<Game> gameList = gameRepository.findByPlayerName(name);
        if(gameList == null || gameList.isEmpty()) {
            return null;
        }
        List<GameDto> gameDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Game game : gameList) {
            gameDtoList.add(modelMapper.map(game, GameDto.class));
        }
        return gameDtoList;
    }*/
}
