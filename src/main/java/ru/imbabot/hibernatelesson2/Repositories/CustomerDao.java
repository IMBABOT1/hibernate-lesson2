package ru.imbabot.hibernatelesson2.Repositories;

import ru.imbabot.hibernatelesson2.Entities.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    Customer saveOrUpdate(Customer product);

}
