package com.example.Ecommerce.Services.Product;

import com.example.Ecommerce.Model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    void assignToProductPicture(Long idProducts, Long idProductpicture);
    //Productpicture assign2(Long idProducts, Long idProductpicture);
    long countByIdProducts(Long idProducts);

    void assignToProductCtegory(Product product , Long idProductCategory);

    Product createProduct(Product product ,Long idProductCategory);
    Product updateProduct(Long idProducts,Product product ,Long idProductCategory);



    void deleteProductByID(Long idProducts);

    //======================== GET ====================================//
    List<Product> GetAll();
    Product GetById(Long idProducts);
    List<Optional<Product>> findByNameProductsStartsWith(String nameProducts);
    List<Optional<Product>> findByCreatedatProduct(String createdatProduct);
    List<Optional<Product>> findByProductCategory_NameProductCategoryStartsWith(String nameProductCategory);

    //====================== END GET ===================================//

}
