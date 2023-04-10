package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.USERADRESSE;
import com.example.Ecommerce.Repository.UserAdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdresseService implements IUserAdresseService{
    @Autowired
    UserAdresseRepository userAdresseRepository;

    @Override
    public List<USERADRESSE> getAllUserAdresse() {
        return userAdresseRepository.findAll();
    }

    @Override
    public void DeletUseradresse(Long idUserAdresse) {
        userAdresseRepository.deleteById(idUserAdresse);
    }

    @Override
    public USERADRESSE getOneUserAdresseById(Long idUserAdresse) {
        return userAdresseRepository.findById(idUserAdresse).get();
    }
}
