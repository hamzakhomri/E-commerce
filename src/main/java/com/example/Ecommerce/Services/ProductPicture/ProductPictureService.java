package com.example.Ecommerce.Services.ProductPicture;

import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Repository.ProductPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPictureService implements IProductPictureService{
    @Autowired
    ProductPictureRepository productPictureRepository;

    public Productpicture create(Productpicture productPicture) {
        return productPictureRepository.save(productPicture);
    }

    @Override
    public List<Productpicture> GetAll() {
        return productPictureRepository.findAll();
    }
}
