package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.User.Useradresse;
import java.util.List;

public interface IUserAdresseService {
    Useradresse findByUserr_NameUserLike(String nameUser);
    Useradresse update( Long idUser, Useradresse useradresse);
    Useradresse create(Useradresse useradresse);
    Useradresse getOneByID(Long idUserAdresse);
    List<Useradresse> getlAll();
    Useradresse assign(Long idUser,Useradresse useradresse);
}
