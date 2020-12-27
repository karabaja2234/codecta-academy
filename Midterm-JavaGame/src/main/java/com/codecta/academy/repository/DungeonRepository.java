package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Dungeon;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DungeonRepository extends Repository<Dungeon, Integer>{

    public DungeonRepository() {
        super(Dungeon.class);
    }

    public List<Dungeon> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Dungeon d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
