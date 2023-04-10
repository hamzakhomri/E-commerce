package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.USERADRESSE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdresseRepository extends JpaRepository<USERADRESSE,Long> {
    //USER_ADRESSE findByUserr_IdUser(Long IdUser);

}
