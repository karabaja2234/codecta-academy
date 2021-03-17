package com.codecta.orbofquarkus.orbofquarkus.monsters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MonsterService {
    private MonsterRepository monsterRepository;

    public Iterable<MonsterEntity> findAllMonsters () {
        return monsterRepository.findAll();
    }

    public MonsterEntity createMonster(MonsterEntity entity) {
        return monsterRepository.save(entity);
    }
}
