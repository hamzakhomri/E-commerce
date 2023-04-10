package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

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
    public Userr getOneUserByID(Long IdUser) {
        return this.userRepository.findById(IdUser).get();
    }

    @Override
    public Userr updateUser(Long IdUser, Userr userr) {
        userr.setIdUser(IdUser);
        userRepository.save(userr);
        return userRepository.save(userr);
    }

    @Override
    public void deleteUser(Long IdUser) {
        userRepository.deleteById(IdUser);

    }
}
