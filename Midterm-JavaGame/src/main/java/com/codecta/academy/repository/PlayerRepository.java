package com.codecta.academy.repository;

import com.codecta.academy.repository.entity.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PlayerRepository extends Repository<Player, Integer>{

    public PlayerRepository() {
        super(Player.class);
    }

    /*
    public List<Player> findAllByGameId(Integer gameId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> cq = cb.createQuery(Player.class);
        Root<Player> root = cq.from(Player.class);
        root.fetch("game", JoinType.INNER);
        CriteriaQuery<Player> all = cq.select(root);
        all.where(cb.equal(root.get("game"), gameId));
        TypedQuery<Player> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }*/

    public List<Player> findAllByIdList(List<Integer> ids) {
        Query query = entityManager.createQuery("SELECT d FROM Player d where d.id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
