package org.example;

import org.example.Entity.Item;
import org.example.Entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Movie movie = new Movie();
            movie.setDirector("sujin");
            movie.setActor("bbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();
            Item item = em.find(Item.class, movie.getId());
            System.out.println("item = " + item);

//            Movie findMove = em.find(Movie.class, movie.getId());
//            System.out.println("findMove = " + findMove);

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();

        }finally {
            em.close();
        }

//        Movie movie = new Movie();
//        movie.setDirector("sujin");
//        movie.setActor("bbb");
//        movie.setName("바람과함께 사라지다");
//        movie.setPrice(10000);
//        tx.commit();
//        em.close();
        emf.close();
    }
}
