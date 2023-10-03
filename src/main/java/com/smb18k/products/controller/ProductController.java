package com.smb18k.products.controller;


import com.smb18k.products.ProductsApplication;
import com.smb18k.products.model.Product;
import com.smb18k.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    IProductService productService;



    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        if (productService.getProductByName(product.getName()) != null) {
            return ResponseEntity.badRequest().build();
        }
            productService.createProduct(product);
            return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduts(){
        List<Product> obj = productService.getAllProducts();
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(value = "/getByName",method = RequestMethod.GET)
    public ResponseEntity<Product> getProdutByname(@RequestParam String name){
        Product obj = productService.getProductByName(name);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(value = "/deleteByName",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@RequestParam String name){
        productService.deleteProduct(name);
        return ResponseEntity.ok(name);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<String>  updateProduct(@RequestBody Product product){

        if (product.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("falta el ID");
        }
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Objeto Actualizado");
    }

}
