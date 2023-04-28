package com.example.Ecommerce.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idProducts;
    private String nameProducts;
    private LocalDateTime modified_atUser;
    @CreatedDate()
    private LocalDateTime created_atUser;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProductCategory")
    private ProductCategory productCategory;

}
