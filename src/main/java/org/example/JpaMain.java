package org.example;

import org.example.Entity.Item;
import org.example.Entity.Member;
import org.example.Entity.Movie;
import org.example.Entity.Team;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUserName("member1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("member2");
            member2.setTeam(teamB);
            em.persist(member2);

            em.flush();
            em.clear();


//            Member m = em.find(Member.class, member1.getId());
//            System.out.println("m = " + m.getTeam().getClass());

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            System.out.println("================");
//            m.getTeam().getName();
            System.out.println("================");

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();

        }finally {
            em.close();
        }
    }
}
