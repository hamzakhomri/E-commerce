package com.example.Ecommerce.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long idProducts;
    private String nameProducts;
    private Double priceProducts;
    private Integer qteProducts;

    @CreatedDate()
    private String createdatProduct;
    private String modifiedatProduct;
    //==Relation With Product Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductCategory")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private ProductCategory productCategory;

    //==Relation With Product Picture
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private List<Productpicture> productpictures=new ArrayList<>();


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
    public List<Productpicture> getProductpictures() {
        return productpictures;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }


    public void setProductpictures(List<Productpicture> productpictures) {
        this.productpictures = productpictures;
    }

    public Product get(Product product) {
        return product;
    }


// °°°°°°°END GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°

}
