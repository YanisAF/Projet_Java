package org.example.exercicerecap.java.repository;

import org.example.exercicerecap.java.entity.Client;
import org.example.exercicerecap.java.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientRepository {

    private SessionFactory sessionFactory;
    private Session session;


    public ClientRepository(){
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public Client create(Client client){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            return client;
        } catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Client client){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(client);
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
