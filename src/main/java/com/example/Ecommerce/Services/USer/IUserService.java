package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Userr getOneUserByID(Long IdUser);
    Userr getOneBynameUser(String nameUser);
    Userr create(Userr userr);
    List<Userr> getAllUer();
    Userr update(Long IdUser, Userr userr);
    void deleteUser(Long IdUser);
}
