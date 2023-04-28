package com.example.Ecommerce.Repository.User;

import com.example.Ecommerce.Model.User.Useradresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAdresseRepository extends JpaRepository<Useradresse,Long> {
    boolean existsByUserr_IdUser(Long idUser);

    //List<Useradresse> findByUserr_NameUserLike(String nameUser);

    Optional<Useradresse> findByUserr_NameUserLike(String nameUser);

    //Useradresse findByUserr_NameUserLike(String nameUser);

    //Optional<Useradresse> findByUserr_NameUserLike(String nameUser);


}
