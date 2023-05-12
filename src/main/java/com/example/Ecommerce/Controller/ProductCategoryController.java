package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Services.ProductCartegory.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void deleteProducCAtegory(@PathVariable Long idProductCategory) {
        iProductCategoryService.deleteProductCategory(idProductCategory);
    }
    @PutMapping("/{idProductCategory}")
    public ProductCategory UpdateProductCategroy(@PathVariable Long idProductCategory,@RequestBody ProductCategory productCategory){
        return iProductCategoryService.UpdateProductCategory(idProductCategory,productCategory);
    }
}
