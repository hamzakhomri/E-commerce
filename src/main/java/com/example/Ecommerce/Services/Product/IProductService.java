package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    void deleteProductByID(Long idProducts);
    Product updateProduct(Long idProducts,Product product);

    //======================== GET ====================================
    List<Product> GetAll();
    Product GetById(Long idProducts,Product product);
    Product GetByName(String nameProducts,Product product);
    Product GetByDateCreated(LocalDateTime created_Product,Product product);

}
