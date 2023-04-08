package com.example.Ecommerce.Service.User;

import com.example.Ecommerce.Model.USERR;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public USERR createUser(USERR userr) {
        return userRepository.save(userr);
    }

    @Override
    public List<USERR> getAllUer() {
        return userRepository.findAll();
    }

    @Override
    public USERR getOneUserByID(Long IdUser) {
        return userRepository.findById(IdUser).get();
    }

    @Override
    public USERR updateUser(Long IdUser, USERR userr) {
        userr.setIdUser(IdUser);
        userRepository.save(userr);
        return userRepository.save(userr);
    }

    @Override
    public void deleteUser(Long IdUser) {
        userRepository.deleteById(IdUser);

    }
}
