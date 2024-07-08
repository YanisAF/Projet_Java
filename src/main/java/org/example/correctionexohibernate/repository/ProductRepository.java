package org.example.correctionexohibernate.repository;

import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository extends BaseRepository<org.example.entity.product.Product> {
    @Override
    public org.example.entity.product.Product findById(int id) {
        session = sessionFactory.openSession();
        org.example.entity.product.Product product = session.get(org.example.entity.product.Product.class,id);
        session.close();
        return product;
    }

    @Override
    public List<org.example.entity.product.Product> findAll() {
        List<org.example.entity.product.Product> productList = null;
        session = sessionFactory.openSession();
        Query<org.example.entity.product.Product> produitQuery = session.createQuery("from Product ", org.example.entity.product.Product.class);
        productList = produitQuery.list();
        session.close();
        return productList;
    }
}
