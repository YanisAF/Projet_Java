package org.example.exercicerecap.repository;

import org.example.exercicerecap.entity.NourritureArticle;
import org.example.exercicerecap.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class NourritureArticleRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public NourritureArticleRepository(){ sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public NourritureArticle create(NourritureArticle nourriture){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(nourriture);
            session.getTransaction().commit();
            return nourriture;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(NourritureArticle nourriture){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(nourriture);
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
