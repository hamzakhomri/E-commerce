package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Services.ProductCartegory.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    IProductCategoryService iProductCategoryService;

    @GetMapping()
    public List<ProductCategory> Getall(){
        return iProductCategoryService.GetAll();
    }


    @PostMapping()
    public ProductCategory SavedProduct(@RequestBody ProductCategory productCategory){
        return iProductCategoryService.SaveProductCategory(productCategory);
    }
    @DeleteMapping("/{idProductCategory}")
    public String deleteProducCAtegory(@PathVariable Long idProductCategory) {
        iProductCategoryService.deleteProductCategory(idProductCategory);
        return idProductCategory+"Deleted Succefully";
    }
    @PutMapping("/{idProductCategory}")
    public ProductCategory UpdateProductCategroy(@PathVariable Long idProductCategory,@RequestBody ProductCategory productCategory){
        return iProductCategoryService.UpdateProductCategory(idProductCategory,productCategory);
    }
}
