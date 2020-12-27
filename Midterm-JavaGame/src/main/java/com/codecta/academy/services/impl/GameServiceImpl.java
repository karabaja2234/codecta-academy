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

@ApplicationScoped
@Transactional
public class GameServiceImpl implements GameService {

    @Inject
    PlayerRepository playerRepository;

    @Inject
    GameRepository gameRepository;


    @Override
    public WelcomeMessage welcome() {
        return new WelcomeMessage("Welcome to the game!", "Here you can find....", "Everyday from 8 am to 10 pm");
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
    public GameDto findGameById(Integer id) {
        Game game = gameRepository.findById(id);
        if(game == null) {
            return  null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(game, GameDto.class);
    }

    @Override
    public GameDto addGame(GameDto game) {
        ModelMapper modelMapper = new ModelMapper();
        Game dbGame = modelMapper.map(game, Game.class);
        dbGame = gameRepository.add(dbGame);
        return modelMapper.map(dbGame,GameDto.class);
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

    /*
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
