package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Item;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class ItemRepository extends Repository<Item, Integer>{

    public ItemRepository() {
        super(Item.class);
    }

    public List<Item> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Item d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
