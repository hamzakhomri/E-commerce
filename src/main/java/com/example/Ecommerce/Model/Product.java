package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicUpdate
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
    private List<Productpicture>productpictures;

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

    public ProductCategory getProductCategory(ProductCategory productCategory) {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

// °°°°°°°END GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°

    public void setproductpictre(Productpicture productpicture) {
    }

}
