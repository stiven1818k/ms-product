package com.smb18k.products.services;

import com.smb18k.products.model.Product;
import com.smb18k.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IProductService implements ProductService{

    @Autowired
    ProductRepository products;

    @Override
    public void createProduct(Product product) {
        products.save(product);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return products.findAll();
    }

    @Override
    public Product getProductByName(String name) {
        return products.findByName(name);
    }

    @Override
    public void updateProduct(Product product) {
        products.save(product);
    }

    @Override
    public void deleteProduct(String product) {

        products.delete(this.getProductByName(product));
    }
}
