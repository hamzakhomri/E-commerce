package com.example.Ecommerce.Repository;


import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.Productpicture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductPictureRepository extends JpaRepository<Productpicture,Long> {
}
