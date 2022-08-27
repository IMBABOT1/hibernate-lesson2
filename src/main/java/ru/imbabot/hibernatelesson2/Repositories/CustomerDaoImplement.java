package ru.imbabot.hibernatelesson2.Repositories;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.imbabot.hibernatelesson2.Entities.Customer;
import ru.imbabot.hibernatelesson2.Entities.Product;
import ru.imbabot.hibernatelesson2.Utils.SessionFactoryUtils;

import java.util.List;

@Repository
public class CustomerDaoImplement implements CustomerDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImplement(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> products = session.createQuery("select c from Customer c").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer c = session.find(Customer.class, id);
            session.remove(c);
            session.getTransaction().commit();
        }
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return customer;
        }
    }
}
