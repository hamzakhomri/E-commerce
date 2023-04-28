package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
        product.setCreated_atUser(LocalDateTime.now());
        product.setModified_atUser(LocalDateTime.now());
        return productRepository.save(product);
    }


}
