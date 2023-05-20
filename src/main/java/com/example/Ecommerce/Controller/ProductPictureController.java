package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Services.ProductPicture.IProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{idProductpicture}")
    public Productpicture update(@PathVariable Long idProductpicture,@RequestBody Productpicture productpicture){
        Productpicture updateproductpicture=iProductPictureService.Update(idProductpicture,productpicture);
        if (updateproductpicture!=null){
            return ResponseEntity.ok(updateproductpicture).getBody();
        }else {
            return null;
        }
    }
    @DeleteMapping("/{idProductpicture}")
    public String deleteProductPicutre(@PathVariable Long idProductpicture){
        iProductPictureService.deleteProductPicture(idProductpicture);
        return idProductpicture+": Deleted";
    }
}
