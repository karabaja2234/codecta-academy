package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Monster;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MonsterRepository extends Repository<Monster, Integer>{

    public MonsterRepository() {
        super(Monster.class);
    }

    public List<Monster> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Monster d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
