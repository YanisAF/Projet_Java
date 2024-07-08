package org.example.correctionexohibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionfactorySingleton {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private SessionfactorySingleton() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory (){
        if(sessionFactory != null){
            return sessionFactory;
        }
        new org.example.correctionexohibernate.utils.SessionfactorySingleton();
        return sessionFactory;
    }

    public static void closeSessionFactory (){
        if(!sessionFactory.isClosed()){
            sessionFactory.close();
        }
    }
}
