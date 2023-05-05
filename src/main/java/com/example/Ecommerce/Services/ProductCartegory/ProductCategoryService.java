package com.example.Ecommerce.Services.ProductCartegory;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Repository.ProductCategoryRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ProductCategoryService implements IProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<ProductCategory> GetAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory SaveProductCategory(ProductCategory productCategory) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        productCategory.setCreatedProductCategory(dateTime.format(formatter));
        productCategory.setModifiedProductCategory(dateTime.format(formatter));

        return this.productCategoryRepository.save(productCategory);
    }



}
