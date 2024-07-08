package org.example.exercicerecap.repository;

import org.example.exercicerecap.entity.ModeArticle;
import org.example.exercicerecap.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ModeArticleRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ModeArticleRepository(){ sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public ModeArticle create(ModeArticle modeArticle){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(modeArticle);
            session.getTransaction().commit();
            return modeArticle;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(ModeArticle modeArticle){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(modeArticle);
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
