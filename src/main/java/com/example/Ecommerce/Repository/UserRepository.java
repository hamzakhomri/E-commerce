package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<Userr,Long> {
    List<Optional<Userr>> findByNameUserStartsWith(String nameUser);
    boolean existsByIdUser(Long idUser);
}
