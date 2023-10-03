package com.smb18k.products.services;

import com.smb18k.products.model.Product;

import java.util.List;

public interface ProductService {
    public void createProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductByName(String name);

    public void updateProduct(Product product);

    public void deleteProduct(String product);
}
