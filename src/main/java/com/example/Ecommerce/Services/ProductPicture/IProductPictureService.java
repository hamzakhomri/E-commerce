package com.example.Ecommerce.Services.ProductPicture;

import com.example.Ecommerce.Model.Productpicture;

import java.util.List;
import java.util.Optional;

public interface IProductPictureService {
    List <Optional<Productpicture>>findByProduct_IdProducts(Long idProducts);

    long countByProduct_IdProducts(Long idProducts);
    List<Productpicture> GetAll();
    Productpicture findbyid(Long id);
    Productpicture create(Productpicture productpicture);
    Productpicture Update(Long idProductpicture,Productpicture productpicture);
    void deleteProductPicture(Long idProductpicture);
}
