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
    private Long sizePicture;


    private String namePicture;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    @JsonIgnore
    private Product product;

    //°°°°°°°°°°°GETTER AND SETTER °°°°°°°°°°°°°°°°°°°°°°°°°°
    public Long getIdProductPicture(){
        return this.idProductpicture;
    }
    public void setIdProductpicture(Long idProductpicture) {
        this.idProductpicture = idProductpicture;
    }
    public byte[] getPicture() {
        return picture;
    }
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    public Long getSizePicture() { return sizePicture;  }
    public void setSizePicture(Long sizePicture) { this.sizePicture = sizePicture; }
    public String getNamePicture() { return namePicture; }
    public void setNamePicture(String namePicture) { this.namePicture = namePicture; }



}
