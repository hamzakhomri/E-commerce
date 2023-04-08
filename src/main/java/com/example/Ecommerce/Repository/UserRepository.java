package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.USERR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<USERR,Long> {
}
