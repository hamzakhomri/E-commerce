package com.example.Ecommerce.Repository.User;

import com.example.Ecommerce.Model.User.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userr,Long> {
    Optional<Userr> findByNameUserStartsWith(String nameUser);


}
