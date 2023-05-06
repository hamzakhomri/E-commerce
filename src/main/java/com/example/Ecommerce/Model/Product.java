package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idProducts;
    private String nameProducts;
    @CreatedDate()
    private String createdatProduct;
    private String modifiedatProduct;

    //==Relation With Product Category
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProductCategory")
    @JsonIgnore
    private ProductCategory productCategory;



    //==Relation With Product Picture
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Productpicture> productpictures;

    @ManyToOne
    @JoinColumn(name = "product_id_products")
    private Product product;
    public Product(Product product, ProductCategory productCategory, List<Productpicture> productPictures) {
        this.productpictures=productPictures;
        this.productCategory=productCategory;
        this.product=product;
    }


//°°°°°°°°°°°GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°°

    public Long getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Long idProducts) {
        this.idProducts = idProducts;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public String getCreatedatProduct() {
        return createdatProduct;
    }

    public void setCreatedatProduct(String createdatProduct) {
        this.createdatProduct = createdatProduct;
    }

    public String getModifiedatProduct() {
        return modifiedatProduct;
    }

    public void setModifiedatProduct(String modifiedatProduct) {
        this.modifiedatProduct = modifiedatProduct;
    }


    public Product(Long idProducts){
        this.idProducts=idProducts;
    }



    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public List<Productpicture> getProductpictures() {
        return productpictures;
    }

    public void setProductpictures(List<Productpicture> productpictures) {
        this.productpictures = productpictures;
    }


// °°°°°°°END GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°

}
