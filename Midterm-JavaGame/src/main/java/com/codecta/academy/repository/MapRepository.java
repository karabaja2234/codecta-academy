package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MapRepository extends Repository<Map, Integer>{

    public MapRepository() {
        super(Map.class);
    }

    public List<Map> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Map d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
