package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByIdProducts(Long idProducts);
    Optional<Product> findByNameProductsStartsWith(String nameProducts);
    //Optional<Product> findByCreated_atUser(LocalDateTime created_Product);
}
