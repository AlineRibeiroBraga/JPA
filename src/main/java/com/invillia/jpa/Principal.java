package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bancodedados");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("---------------------------------------------");
        final TeamDAO teamDAO = new TeamDAO(entityManager);
//        com.invillia.jpa.Team team1 = new com.invillia.jpa.Team("incubadora");
        Team team2 = new Team("careStore");
        //teamDAO.inserir(team1); ok
        //System.out.println(teamDAO.buscarTudo());
        // System.out.println(teamDAO.buscarId(2L));
        //teamDAO.update(team2); ok
        //teamDAO.deletarId(4L); ok

        final MemberDAO memberDAO = new MemberDAO(entityManager);

        Member member = new Member("Rafa", team2);
        //memberDAO.inserir(member);
        //memberDAO.deletarId(3L); ok
        //System.out.println(memberDAO.buscarId(2L)); ok
        //memberDAO.deletarId(4L); ok

        //System.out.println(memberDAO.buscarTudo());
        memberDAO.update(member);

    }
}

