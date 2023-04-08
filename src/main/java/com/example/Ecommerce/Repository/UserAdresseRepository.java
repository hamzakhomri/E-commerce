package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.USER_ADRESSE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdresseRepository extends JpaRepository<USER_ADRESSE,Long> {
    USER_ADRESSE findByUserr_IdUser(Long IdUser);

}
