package com.codecta.orbofquarkus.orbofquarkus.levels;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LevelService {
    private LevelRepository levelRepository;

    public Iterable<LevelEntity> findAllLevels () {
        return levelRepository.findAll();
    }

    public LevelEntity createLevel(LevelEntity entity) {
        return levelRepository.save(entity);
    }
}
