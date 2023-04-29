package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Services.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private IProductService iProductService;

    @PostMapping()
    public Product create(@RequestBody Product product){
        return iProductService.createProduct(product);
    }
    @PutMapping("/{idProducts}")
    public Product update(@PathVariable Long idProducts,@RequestBody Product product){
        Product updateProduct =iProductService.updateProduct(idProducts,product);
        if (updateProduct!=null){
            return ResponseEntity.ok(updateProduct).getBody();
        }else {
            return null;
        }
    }

    @DeleteMapping("/{idProducts}")
    public void deleteProduct(@PathVariable Long idProducts){
        this.iProductService.deleteProductByID(idProducts);
    }

    //======================== GET ====================================
    @GetMapping()
    public List<Product> GrtAll(){
        return iProductService.GetAll();
    }
    @GetMapping("/{idProducts}")
    public Product GetById (@PathVariable Long idProducts){
        return iProductService.GetById(idProducts);
    }

    @GetMapping("/{nameProducts}")
    public Product GetByName (@PathVariable String nameProducts){
        return iProductService.GetByName(nameProducts);
    }
    //@GetMapping("/{created_Product}")
    //public Product GetByDate(@PathVariable LocalDateTime created_Product){return iProductService.GetByDateCreated(created_Product);}
}
