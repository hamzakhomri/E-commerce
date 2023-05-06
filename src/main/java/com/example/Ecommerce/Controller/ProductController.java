package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Repository.ProductCategoryRepository;
import com.example.Ecommerce.Repository.ProductPictureRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Services.Product.IProductService;
import com.example.Ecommerce.Services.Product.ProductService;
import com.example.Ecommerce.Services.ProductCartegory.ProductCategoryService;
import com.example.Ecommerce.Services.ProductPicture.ProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductPictureRepository productPictureRepository;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductPictureService productPictureService;



    @PutMapping("/{idProducts}/categories/{idProductCategory}")
    public ResponseEntity<Void> assignProductToCategory(@PathVariable Long idProducts,@PathVariable Long idProductCategory){
        iProductService.assignToProductCtegory(idProducts,idProductCategory);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{idProducts}/picture/{idProductpicture}")
    public ResponseEntity<Void> assign2(@PathVariable Long idProducts,@PathVariable Long idProductpicture){
        productService.assignToProductPicture(idProducts,idProductpicture);
        return ResponseEntity.ok().build();
    }



    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product.setCreatedatProduct(LocalDateTime.now().toString());
        product.setModifiedatProduct(LocalDateTime.now().toString());
        Product createdProduct = iProductService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
    //======================== GET ====================================
    @GetMapping("/product/{idProduct}")
    public Product getProduct(@PathVariable Long idProducts) {
        Product product = productService.getProductById(idProducts);
        ProductCategory productCategory = productCategoryService.getProductCategoryByProductId(idProducts);
        List<Productpicture> productPictures = productPictureService.getProductPicturesByProductId(idProducts);
        return new Product(product, productCategory, productPictures);
    }
    @GetMapping("/{idProducts}")
    public ResponseEntity<Product> getProductById(@PathVariable Long idProducts) {
        Product product = productService.GetById(idProducts);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/filterbyname/{nameProducts}")
    public List<Product> GetProductBynameProducts(@PathVariable String nameProducts){
        return iProductService.findByNameProductsStartsWith(nameProducts);
    }

    @GetMapping("/filtrecategoryname")
    public List<Optional<Product>> getProductByCategoryName(String nameProductCategory){
        return iProductService.findByProductCategory_NameProductCategoryStartsWith(nameProductCategory);
    }


    @GetMapping("/filerbydatecreated")
    public  List<Optional<Product>> findByCreated_atProduct(@RequestParam(name = "createdatProduct") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String createdatProduct){
        return iProductService.findByCreatedatProduct(createdatProduct);
    }
    //======================== END GET ====================================
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
