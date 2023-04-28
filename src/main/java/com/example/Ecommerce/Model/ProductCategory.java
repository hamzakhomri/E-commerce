package com.example.Ecommerce.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductCategory;
    private String nameProductCategory;
    private LocalDateTime modified_Product;
    @CreatedDate()
    private LocalDateTime created_Product;

    @OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private List<Product> products;
}
