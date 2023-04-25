package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Model.Userr;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Userr update(Long IdUser , Userr userr);
    Userr getOneUserByID(Long IdUser);
    Userr getOneBynameUser(String nameUser);
    Userr create(Userr userr);
    List<Userr> getAllUer();
    void deleteUser(Long IdUser);
}
