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
@CrossOrigin("http://localhost:8082/home")
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

    @GetMapping("/categorieswithproductsandpictures")
    public List<ProductCategory> getCategoryAndPictureWithProduct() {
        ProductCategory oldproductCategory= (ProductCategory) productCategoryRepository.findAll();
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        for (ProductCategory pc : productCategories) {
            List<Product> products = pc.getProducts(oldproductCategory.getProducts());
            for (Product p : products) {
                List<Productpicture> productPictures = p.getProductpictures();
                p.setProductpictures(productPictures);
            }
            pc.setProducts(products);
        }
        return  productCategories;
    }

    @PutMapping("/{idProducts}/picture/{idProductpicture}")
    public ResponseEntity<Void> assign2(@PathVariable Long idProducts,@PathVariable Long idProductpicture){
        productService.assignToProductPicture(idProducts,idProductpicture);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idProductCategory}")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable("idProductCategory") Long idProductCategory) {
        product.setCreatedatProduct(LocalDateTime.now().toString());
        product.setModifiedatProduct(LocalDateTime.now().toString());
        Product createdProduct = productService.createProduct(product, idProductCategory);
        return ResponseEntity.ok(createdProduct);
    }
    //======================== GET ====================================

    @GetMapping("/{idProducts}")
    public ResponseEntity<Product> getProductById(@PathVariable Long idProducts) {
        Product product = iProductService.GetById(idProducts);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/filterbyname")
    public List<Optional<Product>>GetProductBynameProducts( String nameProducts){
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
    @GetMapping()
    public List<Product> getAll(){
        return iProductService.GetAll();
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
    public String deleteProduct(@PathVariable Long idProducts){
        this.iProductService.deleteProductByID(idProducts);
        return idProducts+": Deleted";
    }
}
