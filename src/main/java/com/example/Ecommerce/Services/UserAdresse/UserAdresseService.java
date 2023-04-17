package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Repository.UserAdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdresseService implements IUserAdresseService {
    @Autowired
    UserAdresseRepository userAdresseRepository;
    @Override
    public Useradresse create(Useradresse useradresse){
        return userAdresseRepository.save(useradresse);
    }

    @Override
    public Useradresse getOneByID(Long idUserAdresse) {
        return userAdresseRepository.findById(idUserAdresse).get();
    }

    @Override
    public List<Useradresse> getlAll() {
        return userAdresseRepository.findAll();
    }

    @Override
    public Useradresse assign(Long idUser, Useradresse useradresse) {
        useradresse.setUserr(new Userr(idUser));
        return userAdresseRepository.save(useradresse);
    }


}
