package com.example.Ecommerce.Services.ProductCartegory;

import com.example.Ecommerce.Model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> GetAll();
    ProductCategory SaveProductCategory(ProductCategory productCategory);
    ProductCategory UpdateProductCategory(Long idProductCategory,ProductCategory productCategory);
    void deleteProductCategory(Long idProductCategory);
}
