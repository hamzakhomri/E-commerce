package com.example.Ecommerce.Repository;


import com.example.Ecommerce.Model.Useradresse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserAdresseRepository extends JpaRepository<Useradresse,Long> {
    List<Optional<Useradresse>> findByUserr_NameUserStartsWith(String nameUser);
    boolean existsByUserr_IdUser(Long idUser);
}
