package com.example.Ecommerce.Services.ProductPicture;

import com.example.Ecommerce.Model.Productpicture;

import java.util.List;

public interface IProductPictureService {
    List<Productpicture> GetAll();
    Productpicture create(byte[] picture);
    Productpicture Update(Long idProductpicture,Productpicture productpicture);
    void deleteProductPicture(Long idProductpicture);
}
