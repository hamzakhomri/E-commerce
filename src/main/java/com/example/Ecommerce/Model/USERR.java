package com.example.Ecommerce.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class USERR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    private String NameUser;
    private String PasswordUSer;
    private String FirstNameUser;
    private String LastNameUser;
    private String PhoneUSer;
    private LocalDate created_atUser;
    private LocalDate modified_atUser;
}
