package com.example.Ecommerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor


public class Productpicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProductpicture;
    private String nameProductpicture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct")
    private Product product;

    public void getProductpicturesx(Long idProductpicture) {
        this.setIdProductpicture(idProductpicture);
    }
}
