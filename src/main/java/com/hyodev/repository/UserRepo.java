package com.hyodev.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hyodev.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
  
  Optional<User> findByEmail(String email);


  
}
