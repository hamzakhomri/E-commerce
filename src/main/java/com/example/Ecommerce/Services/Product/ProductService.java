package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
        product.setCreated_atProduct(LocalDateTime.now());
        product.setModified_atProduct(LocalDateTime.now());
        return this.productRepository.save(product);
    }
    public boolean IfExistProduct(Long idProducts){
        return productRepository.existsByIdProducts(idProducts);
    }

    @Override
    public void deleteProductByID(Long idProducts) {
            productRepository.deleteById(idProducts);
    }

    @Transactional
    @Override
    public Product updateProduct(Long idProducts, Product product) {
        if (IfExistProduct(idProducts)==true){

            Product old = productRepository.findById(idProducts).get();
            //========= WhatCan I UPdated ===================
            product.setIdProducts(idProducts);
            product.setModified_atProduct(LocalDateTime.now());
            product.setCreated_atProduct(old.getCreated_atProduct());
            return productRepository.save(product);
        }else {
            return null;
        }
    }


    //======================== GET ====================================

    @Override
    public List<Product> GetAll() {
        return productRepository.findAll();
    }
    @Override
    public Product GetById(Long idProducts) {
        return productRepository.findById(idProducts).orElse(null);
    }

    @Override
    public Product GetByName( String nameProducts) {
        return productRepository.findByNameProductsStartsWith(nameProducts).orElse(new Product());
    }
   // @Override
    //public Product GetByDateCreated(LocalDateTime created_Product){
     //   return productRepository.findByCreated_atUser(created_Product).orElse(null);
    //}
}
