package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category JOIN FETCH p.picture WHERE p.id = :id")
    Optional<Product> findByIdWithCategoryAndPicture(@Param("id") Long id);

    //===================  FIND TO ASIGNING ===================================
    boolean existsByProductCategory_IdProductCategory(Long idProductCategory);
    boolean existsByProductpictures_IdProductpicture(Long idProductpicture);

    //=================  END FIND TO ASIGNING =================================

    boolean existsByIdProducts(Long idProducts);
    boolean existsByProductCategory_IdProductCategoryAndProductpictures_IdProductpicture(Long idProductCategory, Long idProductpicture);
    List<Product> findByNameProductsStartsWith(String nameProducts);
    List<Optional<Product>> findByCreatedatProduct(String createdatProduct);

    List<Optional<Product>> findByProductCategory_NameProductCategoryStartsWith(String nameProductCategory);



}
