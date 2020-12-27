package com.codecta.academy.services;

import com.codecta.academy.repository.entity.WelcomeMessage;
import com.codecta.academy.services.model.*;

import java.util.List;

public interface GameService {
    WelcomeMessage welcome();

    List<PlayerDto> findAllPlayers();
    PlayerDto findPlayerById(Integer id);
    PlayerDto updatePlayer(Integer id, PlayerDto player);
    List<GameDto> findAllGames();
    GameDto findGameById(Integer id);
    GameDto addGame(GameDto game);
    GameDto updateGame(Integer id, GameDto game);
    /*
    List<GameDto> findGameByPlayerName(String name);
    List<PlayerDto> findPlayerByGameId(Integer id);
    */
}
