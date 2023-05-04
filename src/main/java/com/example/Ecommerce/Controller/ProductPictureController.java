package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Services.ProductPicture.IProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productpicture")
public class ProductPictureController {
    @Autowired
    IProductPictureService iProductPictureService;

    @PostMapping()
    public Productpicture create(@RequestBody Productpicture productpicture){
        return iProductPictureService.create(productpicture);
    }
    @GetMapping()
    public List<Productpicture> getAll(){
        return iProductPictureService.GetAll();
    }
}
