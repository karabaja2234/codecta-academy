package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class GameRepository extends Repository<Game, Integer> {
    public GameRepository() {
        super(Game.class);
    }

    public List<Game> findByPlayerName(String name)
    {
        Query query = entityManager.createQuery("SELECT distinct t FROM Game t JOIN t.players c where c.name like :name");
        query.setParameter("name", name + '%');
        List resultList = query.getResultList();
        return (List<Game>) resultList;
    }
}
