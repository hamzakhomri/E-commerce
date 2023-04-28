package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
        product.setCreated_atUser(LocalDateTime.now());
        product.setModified_atUser(LocalDateTime.now());
        return productRepository.save(product);
    }


    @Override
    public void deleteProductByID(Long idProducts) {
            productRepository.deleteById(idProducts);
    }

    @Override
    public Product updateProduct(Long idProducts, Product product) {
        if (!IfExistProduct(idProducts)){
            product.setIdProducts(idProducts);
            product.setModified_atUser(LocalDateTime.now());
            return product;
        }else {
            return null;
        }
    }


    //======================== GET ====================================
    public boolean IfExistProduct(Long idProducts){
        return productRepository.existsByIdProducts(idProducts);
    }
    @Override
    public List<Product> GetAll() {
        return productRepository.findAll();
    }
    @Override
    public Product GetById(Long idProducts,Product product) {
        return productRepository.findById(idProducts).orElse(null);
    }

    @Override
    public Product GetByName( String nameProducts,Product product) {
        return productRepository.findByNameProductsStartsWith(nameProducts).orElse(new Product());
    }
    @Override
    public Product GetByDateCreated(LocalDateTime created_Product,Product product){
        return productRepository.findByCreated_atUser(created_Product).orElse(null);
    }
}
