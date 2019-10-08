package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberDAO {

    private final EntityManager entityManager;

    public MemberDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserir(final Member member) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(member);
        transaction.commit();
    }
   /* public List<com.invillia.jpa.Team> buscarTudo(){

        final TypedQuery<com.invillia.jpa.Team> teams = entityManager.createQuery("from com.invillia.jpa.Team",com.invillia.jpa.Team.class);
        return teams.getResultList();
    }*/

    public List<Member> buscarTudo() {
        TypedQuery<Member> query = entityManager.createQuery("from Member", Member.class);
        return query.getResultList();

    }

    public Member buscarId(final Long id) {
        return entityManager.find(Member.class, id);
    }

    public void update(final Member member) {

        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(member);
        transaction.commit();
    }

    public void deletarId(final Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Member member = buscarId(id);
        entityManager.remove(member);
        transaction.commit();
    }
}
