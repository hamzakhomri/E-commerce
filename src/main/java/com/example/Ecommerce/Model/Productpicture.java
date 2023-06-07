package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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



    @Lob
    private byte[] picture;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    @JsonIgnore
    private Product product;
    //°°°°°°°°°°°GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°°


    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    public Long getIdProductPicture(){
        return this.idProductpicture;
    }
    public void setIdProductpicture(Long idProductpicture) {
        this.idProductpicture = idProductpicture;
    }


}
