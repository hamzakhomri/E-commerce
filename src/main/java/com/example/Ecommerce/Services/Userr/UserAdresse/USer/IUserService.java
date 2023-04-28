package com.example.Ecommerce.Services.Userr.UserAdresse.USer;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;

import java.util.List;

public interface IUserService {
    Userr update(Long IdUser , Userr userr);
    Userr update2(Long IdUser, Userr userr, Useradresse useradresse);
    Userr getOneUserByID(Long IdUser);
    Userr getOneBynameUser(String nameUser);
    Userr create(Userr userr);
    List<Userr> getAllUer();
    void deleteUser(Long IdUser);
}
