package com.example.Ecommerce.Services.ProductPicture;

import com.example.Ecommerce.Model.Productpicture;

import java.util.List;

public interface IProductPictureService {

    long countByProduct_IdProducts(Long idProducts);
    List<Productpicture> GetAll();
    Productpicture findbyid(Long id);
    Productpicture create(Productpicture productpicture);
    Productpicture Update(Long idProductpicture,Productpicture productpicture);
    void deleteProductPicture(Long idProductpicture);
}
