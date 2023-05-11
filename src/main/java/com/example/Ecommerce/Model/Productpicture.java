package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor


public class Productpicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductpicture;
    private String nameProductpicture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    @JsonIgnore
    private Product product;

















    public String getNameProductpicture() {
        return nameProductpicture;
    }
    public Long getIdProductPicture(){
        return this.idProductpicture;
    }

    public void setIdProductpicture(Long idProductpicture) {
        this.idProductpicture = idProductpicture;
    }


}
