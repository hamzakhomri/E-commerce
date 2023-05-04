package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Services.Product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private IProductService iProductService;

    //======================== GET ====================================
    @GetMapping()
    public List<Product> GrtAll(){
        return iProductService.GetAll();
    }
    @GetMapping("/{idProducts}")
    public Product GetById (@PathVariable Long idProducts){
        return iProductService.GetById(idProducts);
    }

    @GetMapping("/filterbyname/{nameProducts}")
    public List<Product> GetProductBynameProducts(@PathVariable String nameProducts){
        return iProductService.findByNameProductsStartsWith(nameProducts);
    }

    @GetMapping("/filerbydatecreated")
    public  List<Optional<Product>> findByCreated_atProduct(@RequestParam(name = "createdatProduct") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String createdatProduct){
        return iProductService.findByCreatedatProduct(createdatProduct);
    }
    //======================== END GET ====================================

    @PostMapping("picture/{idProductpicture}")
    public Product create(@RequestBody Product product,@PathVariable Long idProductpicture){


        return iProductService.createProduct(product,idProductpicture);
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
}
