package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
}
