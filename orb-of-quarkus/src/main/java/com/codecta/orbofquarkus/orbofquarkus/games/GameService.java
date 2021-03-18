package com.codecta.orbofquarkus.orbofquarkus.games;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public GameDto createGame(GameDto game) {
        ModelMapper modelMapper = new ModelMapper();
        GameEntity dbGame = modelMapper.map(game, GameEntity.class);
        dbGame = gameRepository.save(dbGame);
        return modelMapper.map(dbGame,GameDto.class);
    }
}
