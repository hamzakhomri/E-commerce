package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    Userr update(Long IdUser , Userr userr);
    Userr getOneUserByID(Long IdUser);
    List<Optional<Userr>> getOneBynameUser(String nameUser);
    Userr create(Userr userr) throws UnknownHostException, SocketException;
    List<Userr> getAllUer();
    void deleteUser(Long IdUser);
}
