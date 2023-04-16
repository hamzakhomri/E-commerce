package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;

import java.util.List;

public interface IUserService {
    Userr create(Userr userr);
    List<Userr> getAllUer();
    Userr getOneUserByID(Long IdUser);
    Userr update(Long IdUser, Userr userr);
    void deleteUser(Long IdUser);
}
