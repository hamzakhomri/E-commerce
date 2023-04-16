package com.example.Ecommerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nameUser;
    //private String passwordUSer;
    //private String firstNameUser;
    //private String lastNameUser;
    //private String phoneUSer;

    private LocalDate modified_atUser;
    @CreatedDate()
    private LocalDate created_atUser;

    @OneToOne(mappedBy = "userr",cascade = CascadeType.ALL)
    private Useradresse userAdresse;

    public Userr(Long idUser){this.idUser=idUser;}

}
