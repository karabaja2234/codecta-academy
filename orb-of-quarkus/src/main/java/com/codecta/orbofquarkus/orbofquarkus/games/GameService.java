package com.codecta.orbofquarkus.orbofquarkus.games;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    public Iterable<GameEntity> findAllGames () {
        return gameRepository.findAll();
    }

    public GameEntity createGame(GameEntity entity) {
        return gameRepository.save(entity);
    }
}
