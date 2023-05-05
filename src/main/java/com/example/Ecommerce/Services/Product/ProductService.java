package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Repository.ProductCategoryRepository;
import com.example.Ecommerce.Repository.ProductPictureRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductPictureRepository productPictureRepository;


    @Override
    public void assign(Long idProducts, Long idProductCategory){
        Product product = productRepository.findById(idProducts).orElse(null);
        ProductCategory product1=productCategoryRepository.findById(idProductCategory).orElse(null);

        product.setProductCategory(new ProductCategory(idProductCategory));
        productRepository.save(product);
    }


    public Productpicture assign2(Long idProducts, Long idProductpicture) {

        // find the Product object
        Product product = productRepository.findById(idProductpicture)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + idProducts + " not found"));
        // find the Productpicture object
        Productpicture productPicture = product.getProductpictures(idProductpicture).stream()
                .orElseThrow(() -> new EntityNotFoundException("Product picture with id " + idProductpicture + " not found"));

        // assign the Product object to the Productpicture object
        productPicture.setProduct(product);

        // save the Productpicture object
        Productpicture savedProductPicture = productPictureRepository.save(productPicture);

        return productPictureRepository.save(productPicture);
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
//=============== If EXISTED ==========================================
    public boolean IfExistProduct(Long idProducts){
        return productRepository.existsByIdProducts(idProducts);
    }
    public boolean IfExistProductPicture(Long idProductpicture){
        return productRepository.existsByProductpictures_IdProductpicture(idProductpicture);}
    public boolean IfExistsProductCategory(Long idProductCategory){
        return productRepository.existsByProductCategory_IdProductCategory(idProductCategory);
    }
    //=============== End If EXISTED ==========================================
    @Override
    public void deleteProductByID(Long idProducts) {
        if (IfExistProduct(idProducts)){
            productRepository.deleteById(idProducts);
        }else {
            System.out.println(idProducts + " : Don't Existed");
        }

    }

    @Transactional
    @Override
    public Product updateProduct(Long idProducts, Product product) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (IfExistProduct(idProducts)){

            Product old = productRepository.findById(idProducts).orElse(null);
            product.setIdProducts(idProducts);
            product.setModifiedatProduct(dateTime.format(formatter));
            product.setCreatedatProduct(old.getCreatedatProduct());

            return productRepository.save(product);
        }else {
            return null;
        }
    }


    //======================== GET ====================================

    @Override
    public List<Product> GetAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByNameProductsStartsWith(String nameProducts) {
        return productRepository.findByNameProductsStartsWith(nameProducts);
    }
    @Override
    public List<Optional<Product>>findByCreatedatProduct (String createdatProduct){
        List<Optional<Product>> finded = productRepository.findByCreatedatProduct(createdatProduct);
        if (finded!=null){
            return finded;
        }else {
            return finded;
        }

    }

    @Override
    public Product GetById(Long idProducts) {
        return productRepository.findById(idProducts).orElse(null);
    }

}
