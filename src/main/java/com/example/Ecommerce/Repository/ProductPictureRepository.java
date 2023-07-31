package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.Productpicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


public interface ProductPictureRepository extends JpaRepository<Productpicture,Long>, JpaSpecificationExecutor<Productpicture> {
    List <Optional<Productpicture>>findByProduct_IdProducts(Long idProducts);
    long countByProduct_IdProducts(Long idProducts);

}
