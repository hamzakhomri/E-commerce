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

    @Override
    public Productpicture create(Productpicture productpicture) {

        return productPictureRepository.save(productpicture);
    }
    @Override
    public Productpicture Update(Long idProductpicture, Productpicture productpicture) {
        Productpicture oldproductpicture=productPictureRepository.findById(idProductpicture).orElse(null);
        if (oldproductpicture!=null){
            productpicture.setIdProductpicture(idProductpicture);
            productpicture.setProduct(oldproductpicture.getProduct());

            return productPictureRepository.save(productpicture);
        }else {
            System.out.println(idProductpicture +" : Dont Existed");
            return null;
        }
    }

    @Override
    public void deleteProductPicture(Long idProductpicture) {
        Productpicture oldproductpicture=productPictureRepository.findById(idProductpicture).orElse(null);
        if (oldproductpicture!=null) {
            productPictureRepository.deleteById(idProductpicture);
        }else {
            System.out.println(idProductpicture +" : Dont Existed");
        }
    }

    @Override
    public List<Productpicture> GetAll() {
        return productPictureRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Productpicture findbyid(Long id) {
       return productPictureRepository.findById(id).orElse(null);
    }

}
