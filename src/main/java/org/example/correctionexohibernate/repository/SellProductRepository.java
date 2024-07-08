package org.example.correctionexohibernate.repository;

import org.hibernate.query.Query;

import java.util.List;

public class SellProductRepository extends BaseRepository<org.example.entity.SellProduct> {
    @Override
    public org.example.entity.SellProduct findById(int id) {
        session = sessionFactory.openSession();
        org.example.entity.SellProduct sellProduct = session.get(org.example.entity.SellProduct.class,id);
        session.close();
        return sellProduct;
    }

    @Override
    public List<org.example.entity.SellProduct> findAll() {
        List<org.example.entity.SellProduct> sellProducts = null;
        session = sessionFactory.openSession();
        Query<org.example.entity.SellProduct> sellProductQuery = session.createQuery("from SellProduct ", org.example.entity.SellProduct.class);
        sellProducts = sellProductQuery.list();
        session.close();
        return sellProducts;
    }
}
