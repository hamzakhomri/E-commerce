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

    //private String adresseline1UserAdresse;
    //private String  cityUserAdresse;
    //private Integer postalcodeUserAdresse;
    //private String countryUserAdresse;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Userr userr;


}
