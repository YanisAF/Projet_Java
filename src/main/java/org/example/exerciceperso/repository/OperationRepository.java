package org.example.exerciceperso.repository;

import org.example.exerciceperso.entity.Operation;
import org.example.exerciceperso.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OperationRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public OperationRepository(){ sessionFactory = SessionFactorySingleton.getSessionFactory(); }

    public Operation create(Operation operation){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(operation);
            session.getTransaction().commit();
            return operation;
        } catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Operation operation){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(operation);
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
