package com.codecta.orbofquarkus.orbofquarkus.levels;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;

    public LevelDto createLevel(LevelDto level) {
        ModelMapper modelMapper = new ModelMapper();
        LevelEntity dbLevel = modelMapper.map(level, LevelEntity.class);
        dbLevel = levelRepository.save(dbLevel);
        return modelMapper.map(dbLevel,LevelDto.class);
    }
}
