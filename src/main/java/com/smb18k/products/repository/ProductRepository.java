package com.smb18k.products.repository;

import com.smb18k.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.name like %?1%")
    public Product findByName(String term);

    @Query("select p from Product p")
    public List<Product> findAll();


}
