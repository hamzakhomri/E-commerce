package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Repository.UserAdresseRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAdresseRepository userAdresseRepository;

    @Override
    public Userr create(Userr userr) {
        userr.setCreated_atUser(LocalDate.now());
        userr.setModified_atUser(LocalDate.now());
        return this.userRepository.save(userr);
    }

    @Override
    public List<Userr> getAllUer() {
        return userRepository.findAll();
    }

    @Override
    public Userr getOneUserByID(Long IdUser) {//dont'Done
        return userRepository.findById(IdUser).get();
    }

    @Override
    public Userr update(Long IdUser, Userr userr) {
        //userr.setIdUser(IdUser);
        //userAdresseRepository.save(userr.getUserAdresse());
        //return userRepository.save(userr);
        Userr existUser = userRepository.findById(IdUser).orElse(null);
        if (existUser!=null){
            existUser.setNameUser((userr.getNameUser()));
            return userRepository.save(existUser);
        }else {
            return null;
        }

    }

    @Override
    public void deleteUser(Long IdUser) {
        userRepository.deleteById(IdUser);

    }
}
