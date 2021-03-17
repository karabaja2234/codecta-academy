package com.codecta.orbofquarkus.orbofquarkus.players;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;

    public Iterable<PlayerEntity> findAllPlayers () {
        return playerRepository.findAll();
    }

    public PlayerEntity createPlayer(PlayerEntity entity) {
        return playerRepository.save(entity);
    }
}
