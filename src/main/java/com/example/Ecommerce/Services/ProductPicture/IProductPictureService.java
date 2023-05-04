package com.example.Ecommerce.Services.ProductPicture;

import com.example.Ecommerce.Model.Productpicture;

import java.util.List;

public interface IProductPictureService {
    Productpicture create(Productpicture productpicture);
    List<Productpicture> GetAll();
}
