package com.example.Ecommerce.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity


public class ProductPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProductPicture;
    private String nameProductPicture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product product;
}
