package com.example.Ecommerce.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity


public class Productpicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProductpicture;
    private String nameProductpicture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product product;
}
