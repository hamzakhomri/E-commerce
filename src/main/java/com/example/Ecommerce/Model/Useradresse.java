package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Useradresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserAdresse;
    private String nameUserAdresse;

    public String getNameUserAdresse() {
        return nameUserAdresse;
    }
    public void setNameUserAdresse(String nameUserAdresse) {
        this.nameUserAdresse = nameUserAdresse;
    }
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Userr userr;

}
