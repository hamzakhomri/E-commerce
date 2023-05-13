package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Model.Productpicture;
import com.example.Ecommerce.Repository.ProductCategoryRepository;
import com.example.Ecommerce.Repository.ProductPictureRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
    public void assignToProductPicture(Long idProducts, Long idProductpicture) {
        Product oldproduct = productRepository.findById(idProducts).orElse(null);
        Productpicture oldpicture = productPictureRepository.findById(idProductpicture).orElse(null);
        oldpicture.setProduct(oldproduct);
        if (oldproduct ==null)
        {
            System.out.println("Product Dont Existed");
            if (oldpicture==null)
            {
                System.out.println("Picture Dont Existed");
            }

        }
        assert oldpicture != null;
        productPictureRepository.save(oldpicture);
        productPictureRepository.findById(idProductpicture).orElse(null);
    }


    @Override
    public void assignToProductCtegory(Long idProducts, Long idProductCategory){
        Product product = productRepository.findById(idProducts).orElse(null);
        ProductCategory product1=productCategoryRepository.findById(idProductCategory).orElse(null);

        product.setProductCategory(new ProductCategory(idProductCategory));
        productRepository.save(product);
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

            product.setProductCategory(old.getProductCategory());

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
    public List<Optional<Product>> findByNameProductsStartsWith(String nameProducts) {
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
    public List<Optional<Product>> findByProductCategory_NameProductCategoryStartsWith(String nameProductCategory) {
        return productRepository.findByProductCategory_NameProductCategoryStartsWith(nameProductCategory);
    }

    @Override
    public Product GetById(Long idProducts) {
        return productRepository.findById(idProducts).orElse(null);
    }

}
