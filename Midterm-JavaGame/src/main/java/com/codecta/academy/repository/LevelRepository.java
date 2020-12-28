package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class LevelRepository extends Repository<Level, Integer>{
    public LevelRepository() {
        super(Level.class);
    }
}
