package com.example.Ecommerce.Services.Userr.UserAdresse;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;
import com.example.Ecommerce.Repository.User.UserAdresseRepository;
import com.example.Ecommerce.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdresseService implements IUserAdresseService {
    @Autowired
    UserAdresseRepository userAdresseRepository;
    @Autowired
    UserRepository userRepository;

    public boolean IfExistUser(Long idUser) {
        return userAdresseRepository.existsByUserr_IdUser(idUser);
    }


    @Override
    public Useradresse findByUserr_NameUserLike(String nameUser) {
        return userAdresseRepository.findByUserr_NameUserLike(nameUser).orElse(null);
    }




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
        if (!IfExistUser(idUser)){
            useradresse.setUserr(new Userr(idUser));
            return userAdresseRepository.save(useradresse);
        }
        else {
            return userAdresseRepository.findById(idUser).get();
        }
    }

    public Useradresse update(Long idUser, Useradresse userAdresse) {
        if (!IfExistUser(idUser)){
            userAdresse.setUserr(userAdresse.getUserr());

            userAdresse.setNameUserAdresse(userAdresse.getNameUserAdresse());
            return userAdresseRepository.save(userAdresse);
        }
        else {
            return userAdresseRepository.findById(idUser).get();
        }
    }


}
