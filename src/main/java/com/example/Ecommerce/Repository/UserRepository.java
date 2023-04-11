package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Userr,Long> {

}
