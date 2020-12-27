package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class LevelRepository extends Repository<Level, Integer>{

    public LevelRepository() {
        super(Level.class);
    }

    public List<Level> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Level d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
