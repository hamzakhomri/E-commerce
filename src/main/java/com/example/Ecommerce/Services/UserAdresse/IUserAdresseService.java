package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.USERADRESSE;

import java.util.List;

public interface IUserAdresseService {

    List<USERADRESSE>getAllUserAdresse();
    USERADRESSE getOneUserAdresseById(Long idUserAdresse);
    void DeletUseradresse(Long idUserAdresse);

}
