package org.example.exerciceperso.repository.comptesbancairesrepo;

import org.example.exerciceperso.entity.comptesbancaires.CompteCourant;
import org.example.exerciceperso.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompteCourantRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public CompteCourantRepository(){ sessionFactory = SessionFactorySingleton.getSessionFactory(); }

    public CompteCourant save(CompteCourant compteCourant){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(compteCourant);
            session.getTransaction().commit();
            return compteCourant;
        } catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(CompteCourant compteCourant){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(compteCourant);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }
}
