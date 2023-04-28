package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    List<Product> GetAll();

}
