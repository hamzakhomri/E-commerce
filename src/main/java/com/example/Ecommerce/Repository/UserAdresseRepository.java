package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Useradresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdresseRepository extends JpaRepository<Useradresse,Long> {
    boolean existsByUserr_IdUser(Long idUser);
}
