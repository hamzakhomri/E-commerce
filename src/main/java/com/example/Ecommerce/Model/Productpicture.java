package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class Productpicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductpicture;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;
    private Long sizePicture;
    private String namePicture;
    @CreatedDate()
    private String createdatPicture;
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
    public Long getSizePicture() { return sizePicture;  }
    public void setSizePicture(Long sizePicture) { this.sizePicture = sizePicture; }
    public String getNamePicture() { return namePicture; }
    public void setNamePicture(String namePicture) { this.namePicture = namePicture; }
    public String getCreatedatPicture() { return createdatPicture; }
    public void setCreatedatPicture(String createdatPicture) { this.createdatPicture = createdatPicture; }


}
