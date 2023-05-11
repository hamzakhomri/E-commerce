package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductCategory;
    private String nameProductCategory;

    @CreatedDate()
    private String createdProductCategory;
    private String modifiedProductCategory;

    @OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();























    public ProductCategory(Long idProductCategory) {
        this.idProductCategory=idProductCategory;
    }

    public Long getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(Long idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getNameProductCategory() {
        return nameProductCategory;
    }
    public void setNameProductCategory(String nameProductCategory) {
        this.nameProductCategory = nameProductCategory;
    }

    public String getModifiedProductCategory() {
        return modifiedProductCategory;
    }

    public void setModifiedProductCategory(String modifiedProductCategory) {
        this.modifiedProductCategory = modifiedProductCategory;
    }

    public String getCreatedProductCategory() {
        return createdProductCategory;
    }

    public void setCreatedProductCategory(String createdProductCategory) {
        this.createdProductCategory = createdProductCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
