package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //===================  FIND TO ASIGNING ===================================
    boolean existsByProductCategory_IdProductCategory(Long idProductCategory);
    boolean existsByProductpictures_IdProductpicture(Long idProductpicture);

    //=================  END FIND TO ASIGNING =================================

    boolean existsByIdProducts(Long idProducts);
    List<Optional<Product>> findByNameProductsStartsWith(String nameProducts);
    List<Optional<Product>> findByCreatedatProduct(String createdatProduct);

    List<Optional<Product>> findByProductCategory_NameProductCategoryStartsWith(String nameProductCategory);



}
