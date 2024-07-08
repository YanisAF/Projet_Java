package org.example.exerciceperso.repository.comptesbancairesrepo;

import org.example.exerciceperso.entity.comptesbancaires.CompteEpargne;
import org.example.exerciceperso.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompteEpargneRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public CompteEpargneRepository(){
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public CompteEpargne save(CompteEpargne compteEpargne){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(compteEpargne);
            session.getTransaction().commit();
            return compteEpargne;
        } catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(CompteEpargne compteEpargne){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(compteEpargne);
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


