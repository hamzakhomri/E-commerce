package com.example.Ecommerce.Model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class USERR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nameUser;
    private String passwordUSer;
    private String firstNameUser;
    private String lastNameUser;
    private String phoneUSer;

    private LocalDate modified_atUser;
    @CreatedDate()
    private LocalDate created_atUser;

    @OneToOne(mappedBy = "userr",cascade = CascadeType.ALL)
    private USER_ADRESSE userAdresse;
}
