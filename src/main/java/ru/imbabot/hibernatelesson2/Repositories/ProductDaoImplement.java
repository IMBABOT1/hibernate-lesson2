package ru.imbabot.hibernatelesson2.Repositories;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.imbabot.hibernatelesson2.Entities.Product;
import ru.imbabot.hibernatelesson2.Utils.SessionFactoryUtils;

import java.util.List;

@Repository
public class ProductDaoImplement implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImplement(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product p = session.find(Product.class, id);
            session.remove(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }
}
