package com.example.Ecommerce.Model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idProducts;
    private String nameProducts;
    @CreatedDate()
    private LocalDateTime created_atProduct;
    private LocalDateTime modified_atProduct;



    public LocalDateTime getModified_atProduct() {
        return modified_atProduct;
    }
    public void setModified_atProduct(LocalDateTime modified_atProduct) {
        this.modified_atProduct = modified_atProduct;
    }

    public LocalDateTime getCreated_atProduct() {
        return created_atProduct;
    }

    public void setCreated_atProduct(LocalDateTime created_atProduct) {
        this.created_atProduct = created_atProduct;
    }






    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProductCategory")
    private ProductCategory productCategory;


    public Long getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Long idProducts) {
        this.idProducts = idProducts;
    }
}
