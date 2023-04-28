package com.example.Ecommerce.Services.Userr.UserAdresse.USer;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;
import com.example.Ecommerce.Repository.User.UserAdresseRepository;
import com.example.Ecommerce.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAdresseRepository userAdresseRepository;



    @Override
    public Userr create(Userr userr) {
        userr.setCreated_atUser(LocalDateTime.now());
        userr.setModified_atUser(LocalDateTime.now());
        return this.userRepository.save(userr);
    }

    @Override
    public List<Userr> getAllUer() {
        return userRepository.findAll();
    }

    @Override
    public Userr getOneUserByID(Long IdUser) {//dont
        return userRepository.findById(IdUser).orElse(null);
    }

    @Override
    public Userr getOneBynameUser(String nameUser) {
        return userRepository.findByNameUserStartsWith(nameUser).orElse(null);
    }


    @Override
    public Userr update(Long IdUser, Userr userr) {
        Userr existUser = userRepository.findById(IdUser).orElse(null);
        if (existUser!=null){
            userr.setModified_atUser(LocalDateTime.now());
            userr.setNameUser(userr.getNameUser());
            return userRepository.save(userr);
        }else {
            return null;
        }
    }

    @Override
    public Userr update2(Long IdUser, Userr userr, Useradresse useradresse) {
        return null;
    }

    @Override
    public void deleteUser(Long IdUser) {
         userRepository.deleteById(IdUser);

    }
}