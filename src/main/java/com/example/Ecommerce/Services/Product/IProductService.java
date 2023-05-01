package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(Product product);
    void deleteProductByID(Long idProducts);
    Product updateProduct(Long idProducts,Product product);

    //======================== GET ====================================//

    List<Product> GetAll();
    Product GetById(Long idProducts);
    List<Product> findByNameProductsStartsWith(String nameProducts);
    List<Optional<Product>> findByCreatedatProduct(String createdatProduct);


}
