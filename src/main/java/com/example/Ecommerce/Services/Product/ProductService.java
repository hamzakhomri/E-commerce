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
        Product product = productRepository.findById(idProducts).orElse(null);
        Productpicture productpicture = productPictureRepository.findById(idProductpicture).orElse(null);

        if (product ==null){
            System.out.println("Product Dont Existed");
            if (productpicture==null){
                System.out.println("Picture Dont Existed");
            }
        }else {
            productpicture.setProduct(product);
            productPictureRepository.save(productpicture);
        }
    }


    @Override
    public void assignToProductCtegory(Long idProducts, Long idProductCategory){
        Product product = productRepository.findById(idProducts).orElse(null);
        ProductCategory productCategory=productCategoryRepository.findById(idProductCategory).orElse(null);
        if (product==null){
            if (productCategory==null){
                System.out.println("Don't Existed");
            }
        }else {
            product.setProductCategory(new ProductCategory(idProductCategory));
            productRepository.save(product);
        }
    }




    public Product createProduct(Product product) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//("dd-MM-yyyy HH:mm:ss")

        product.setCreatedatProduct(dateTime.format(formatter));
        product.setModifiedatProduct(dateTime.format(formatter));//("dd-MM-yyyy HH:mm:ss")
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
  if (IfExistProduct(idProducts)){
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");//("dd-MM-yyyy HH:mm:ss")

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
