package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.Useradresse;
import java.util.List;

public interface IUserAdresseService {
    Useradresse update( Long idUser, Useradresse useradresse);
    Useradresse create(Useradresse useradresse);
    Useradresse getOneByID(Long idUserAdresse);
    List<Useradresse> getlAll();
    Useradresse assign(Long idUser,Useradresse useradresse);
}
