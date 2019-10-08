package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDAO {

    private final EntityManager entityManager;

    public TeamDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserir(final Team team){
        final EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(team);
        entityTransaction.commit();
    }

    public List<Team> buscarTudo(){
        final TypedQuery<Team> teams = entityManager.createQuery("from Team",Team.class);
        return teams.getResultList();                                  //classe com.invillia.jpa.Team
    }

    public Team buscarId(final Long id){
        return entityManager.find(Team.class,id);
    }

    public void update(final Team team) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(team);
        transaction.commit();
    }

    public void deletarId(final Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Team team = buscarId(id);
        entityManager.remove(team);
        transaction.commit();
    }
}
