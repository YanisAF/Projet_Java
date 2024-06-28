package org.example.exercicerecap.java.repository;

import org.example.exercicerecap.java.entity.ElectronicArticle;
import org.example.exercicerecap.java.entity.ModeArticle;
import org.example.exercicerecap.java.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ElectronicArticleRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ElectronicArticleRepository(){ sessionFactory = SessionFactorySingleton.getSessionFactory(); }

    public ElectronicArticle create(ElectronicArticle electronicArticle){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(electronicArticle);
            session.getTransaction().commit();
            return electronicArticle;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(ElectronicArticle electronicArticle){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(electronicArticle);
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
