package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Repository.UserAdresseRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAdresseService implements IUserAdresseService {
    @Autowired
    UserAdresseRepository userAdresseRepository;
    @Autowired
    UserRepository userRepository;

    public boolean IfExistUser(Long idUser) {
        return userAdresseRepository.existsByUserr_IdUser(idUser);
    }

    //°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    @Override
    public Useradresse getOneByID(Long idUserAdresse) {
        return userAdresseRepository.findById(idUserAdresse).orElse(null);
    }

    @Override
    public List<Useradresse> getlAll() {
        return userAdresseRepository.findAll();
    }

    @Override
    public List<Optional<Useradresse>> findByUserr_NameUserStartsWith(String nameUser) {
        return userAdresseRepository.findByUserr_NameUserStartsWith(nameUser);
    }

    //°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° END GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°



    @Override
    public Useradresse update(Long idUserAdresse, Useradresse useradresse) {
        Useradresse old = userAdresseRepository.findById(idUserAdresse).orElse(null);
        if (IfExistUser(idUserAdresse)){
            useradresse.setUserr(old.getUserr());
            useradresse.setIdUserAdresse(idUserAdresse);
            return userAdresseRepository.save(useradresse);
        }
        else {
            return old;
        }
    }
    @Override
    public Useradresse create(Useradresse useradresse){
        return userAdresseRepository.save(useradresse);
    }
    @Override
    public Useradresse assign(Long idUser, Useradresse useradresse) {
        Useradresse old = userAdresseRepository.findById(idUser).orElse(null);
        if (!IfExistUser(idUser)) {
            if (useradresse != null) {
                useradresse.setUserr(new Userr(idUser));
                return userAdresseRepository.save(useradresse);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
