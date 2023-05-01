package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.Useradresse;

import java.util.List;

public interface IUserAdresseService {

    //°°°°°°°°°°°°°°°°°°°°°°°°°°°°° GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    Useradresse getOneByID(Long idUserAdresse);
    List<Useradresse> getlAll();
    List<Useradresse> findByUserr_NameUserStartsWith(String nameUser);

    //°°°°°°°°°°°°°°°°°°°°°°°°°°° END GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    Useradresse update(Long idUserAdresse,Useradresse useradresse);
    Useradresse create(Useradresse useradresse);
    Useradresse assign(Long idUser, Useradresse useradresse);
}
