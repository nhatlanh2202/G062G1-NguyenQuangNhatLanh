package com.codegym.repository.impl;


import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select p from product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findById(Integer product_id) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select s from product s where product_id = :idProduct", Product.class);
        typedQuery.setParameter("idProduct", product_id);

        return typedQuery.getSingleResult();
//        return BaseRepository.entityManager.find(Student.class, id);
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer product_id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(product_id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
