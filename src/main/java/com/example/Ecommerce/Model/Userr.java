package com.example.Ecommerce.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private String passwordUSer;
    //private String firstNameUser;
    //private String lastNameUser;
    //private String phoneUSer;


    private Long idUser;
    private String nameUser;
    private LocalDateTime modified_atUser;
    @CreatedDate()
    private LocalDateTime created_atUser;


    @OneToOne(mappedBy = "userr",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Useradresse userAdresse;


    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public Userr(Long idUser) {
        this.idUser = idUser;
    }


}
