package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userr,Long> {
    Optional<Userr> findByNameUserStartsWith(String nameUser);
    boolean existsByIdUser(Long idUser);

}
