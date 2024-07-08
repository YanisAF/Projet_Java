package org.example.exerciceperso.repository.comptesbancairesrepo;

import org.example.exerciceperso.entity.Operation;
import org.example.exerciceperso.entity.comptesbancaires.CompteBancaire;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompteBancaireRepository {
    private SessionFactory sessionFactory;
    private Session session;


    public CompteBancaire create(CompteBancaire compteBancaire){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(compteBancaire);
            session.getTransaction().commit();
            return compteBancaire;
        } catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(CompteBancaire compteBancaire){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(compteBancaire);
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
