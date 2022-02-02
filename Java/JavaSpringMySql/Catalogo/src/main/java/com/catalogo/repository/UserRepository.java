package com.catalogo.repository;

import com.catalogo.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
 
    List<User> findByEmail(String email);
    User findByUsernameOrEmail(String username, String email);
    List<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}
