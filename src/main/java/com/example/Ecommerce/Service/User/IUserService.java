package com.example.Ecommerce.Service.User;

import com.example.Ecommerce.Model.USERR;

import java.util.List;

public interface IUserService {
    USERR create(USERR userr);
    List<USERR> getAllUer();
    USERR getOneUserByID(Long IdUser);
    USERR updateUser(Long IdUser,USERR userr);
    void deleteUser(Long IdUser);
}
