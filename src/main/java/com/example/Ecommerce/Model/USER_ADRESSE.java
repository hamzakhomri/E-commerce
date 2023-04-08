package com.example.Ecommerce.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class USER_ADRESSE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUserAdresse;
    private String adresseline1UserAdresse;
    private String  adresseline2UserAdresse;
    private String  cityUserAdresse;
    private Integer postalcodeUserAdresse;
    private String countryUserAdresse;

    @OneToOne
    @JoinColumn(name = "user_id")
    private USERR userr;

}
