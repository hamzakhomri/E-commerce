package com.example.Ecommerce.Services.ProductCartegory;

import com.example.Ecommerce.Model.ProductCategory;
import com.example.Ecommerce.Repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ProductCategoryService implements IProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> GetAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory SaveProductCategory(ProductCategory productCategory) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        productCategory.setCreatedProductCategory(dateTime.format(formatter));
        productCategory.setModifiedProductCategory(dateTime.format(formatter));

        return this.productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory UpdateProductCategory(Long idProductCategory, ProductCategory productCategory) {
        ProductCategory oldproductCategory=productCategoryRepository.findById(idProductCategory).orElse(null);
        if (oldproductCategory!=null){
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            productCategory.setModifiedProductCategory(dateTime.format(formatter));
            productCategory.setCreatedProductCategory(oldproductCategory.getCreatedProductCategory());
            productCategory.setIdProductCategory(idProductCategory);

            productCategory.getProducts(oldproductCategory.getProducts(oldproductCategory.getProducts()));

            return this.productCategoryRepository.save(productCategory);
        }else {
            System.out.println(idProductCategory +": Don't existed");
            return null;
        }
    }

    @Override
    public void deleteProductCategory(Long idProductCategory) {
        ProductCategory oldproductCategory=productCategoryRepository.findById(idProductCategory).orElse(null);
        if (oldproductCategory!=null){
            productCategoryRepository.deleteById(idProductCategory);
        }else {
            System.out.println(idProductCategory +": Don't existed");
        }
    }


}
