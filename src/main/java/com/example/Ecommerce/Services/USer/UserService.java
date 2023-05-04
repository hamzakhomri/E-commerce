package com.example.Ecommerce.Services.USer;

import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;


    public boolean IFExistUset(Long idUser){
        return userRepository.existsByIdUser(idUser);
    }

    @Override
    public Userr create(Userr userr) throws UnknownHostException, SocketException {

        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        userr.setAdresseIP(ipAddress);

        userr.setAdresseMAC(userr.getAdresseMAC());

        userr.setCreated_atUser(LocalDateTime.now());
        userr.setModified_atUser(LocalDateTime.now());
        return this.userRepository.save(userr);
    }

    @Override
    public List<Userr> getAllUer() {
        return userRepository.findAll();
    }


    @Override
    public Userr update(Long IdUser, Userr userr) {
        Userr oldUser=userRepository.findById(IdUser).orElse(null);
        if (IFExistUset(IdUser)){
            userr.setIdUser(IdUser);
            userr.setModified_atUser(LocalDateTime.now());
            userr.setCreated_atUser(oldUser.getCreated_atUser());
            userr.setAdresseMAC(oldUser.getAdresseMAC());
            userr.setAdresseIP(oldUser.getAdresseIP());
            return userRepository.save(userr);
        }
        else {
            return oldUser;
        }
    }

    @Override
    public Userr getOneUserByID(Long IdUser) {//dont
        return userRepository.findById(IdUser).orElse(null);
    }

    @Override
    public List<Optional<Userr>> getOneBynameUser(String nameUser) {
        return userRepository.findByNameUserStartsWith(nameUser);
    }

    @Override
    public void deleteUser(Long IdUser) {
        if (IFExistUset(IdUser)){
            userRepository.deleteById(IdUser);
        }else {
            userRepository.findById(IdUser);
        }
    }
}
