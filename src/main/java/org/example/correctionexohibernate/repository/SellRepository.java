package org.example.correctionexohibernate.repository;

import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class SellRepository extends BaseRepository<org.example.entity.Sell>{
    @Override
    public org.example.entity.Sell findById(int id) {
        session = sessionFactory.openSession();
        org.example.entity.Sell sell = session.get(org.example.entity.Sell.class,id);
        session.close();
        return sell;
    }

    @Override
    public List<org.example.entity.Sell> findAll() {
        List<org.example.entity.Sell> sellList = null;
        session = sessionFactory.openSession();
        Query<org.example.entity.Sell> sellQuery = session.createQuery("from Sell", org.example.entity.Sell.class);
        sellList = sellQuery.list();
        session.close();
        return sellList;
    }

    public List<org.example.entity.Sell> findByDate (LocalDate dateStart, LocalDate dateStop){
        List<org.example.entity.Sell> sellList = null;
        Query<org.example.entity.Sell> sellQuery;
        session = sessionFactory.openSession();
        if(dateStop != null){
            sellQuery = session.createQuery("from Sell where sellDate > :datestart AND sellDate < :datestop", org.example.entity.Sell.class);
            sellQuery.setParameter("datestart",dateStart);
            sellQuery.setParameter("datestop",dateStop);
        }else{
            sellQuery = session.createQuery("from Sell where sellDate > :datestart ", org.example.entity.Sell.class);
            sellQuery.setParameter("datestart",dateStart);
        }

        sellList = sellQuery.list();
        session.close();
        return sellList;
    }
}
