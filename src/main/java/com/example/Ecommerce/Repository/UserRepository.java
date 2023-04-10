package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr,Long> {
}
