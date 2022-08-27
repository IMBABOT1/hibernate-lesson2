package ru.imbabot.hibernatelesson2.Repositories;

import ru.imbabot.hibernatelesson2.Entities.Product;

import java.util.List;

public interface ProductDao {


    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);

}
