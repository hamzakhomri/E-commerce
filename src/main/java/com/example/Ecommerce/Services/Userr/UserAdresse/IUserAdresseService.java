package com.example.Ecommerce.Services.Userr.UserAdresse;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;

import java.util.List;

public interface IUserAdresseService {
    Useradresse update(Long idUserAdresse,Useradresse useradresse);
    Useradresse findByUserr_NameUserLike(String nameUser);
    Useradresse create(Useradresse useradresse);
    Useradresse getOneByID(Long idUserAdresse);
    List<Useradresse> getlAll();
    Useradresse assign(Long idUser,Useradresse useradresse);
}
