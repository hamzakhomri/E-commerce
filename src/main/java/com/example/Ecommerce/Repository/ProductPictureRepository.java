package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.Productpicture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductPictureRepository extends JpaRepository<Productpicture,Long> {
    long countByProduct_IdProducts(Long idProducts);
    List <Productpicture> findByProduct_IdProducts(Long idProducts);

}
