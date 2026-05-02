package com.klef.fsad.exam;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure(); 
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction tx1 = session1.beginTransaction();

        Movie movie = new Movie();
        movie.setId(101);
        movie.setName("Interstellar");
        movie.setDate("02-05-2026");
        movie.setStatus("Active");

        session1.save(movie);
        tx1.commit();

        System.out.println("Movie Inserted Successfully!");
        System.out.println(movie);

        session1.close();
        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();

        String hql = "UPDATE Movie SET name = ?1, status = ?2 WHERE id = ?3";
        Query query = session2.createQuery(hql);
        query.setParameter(1, "Interstellar Updated");
        query.setParameter(2, "Inactive");
        query.setParameter(3, 101);

        int rowsUpdated = query.executeUpdate();
        tx2.commit();

        System.out.println("\nRows Updated: " + rowsUpdated);
        Movie updatedMovie = session2.get(Movie.class, 101);
        System.out.println("Updated Movie: " + updatedMovie);

        session2.close();
        sessionFactory.close();
    }
}
