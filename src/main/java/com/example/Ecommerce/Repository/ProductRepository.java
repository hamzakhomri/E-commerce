package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {

    //===================  FIND TO ASIGNING ===================================
    boolean existsByProductCategory_IdProductCategory(Long idProductCategory);
    boolean existsByProductpictures_IdProductpicture(Long idProductpicture);

    //=================  END FIND TO ASIGNING =================================

    boolean existsByIdProducts(Long idProducts);
    boolean existsByProductCategory_IdProductCategoryAndProductpictures_IdProductpicture(Long idProductCategory, Long idProductpicture);
    List<Product> findByNameProductsStartsWith(String nameProducts);
    List<Optional<Product>> findByCreatedatProduct(String createdatProduct);



}
