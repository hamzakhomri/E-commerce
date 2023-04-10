package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Useradresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdresseRepository extends JpaRepository<Useradresse,Long> {
    //USER_ADRESSE findByUserr_IdUser(Long IdUser);

}
