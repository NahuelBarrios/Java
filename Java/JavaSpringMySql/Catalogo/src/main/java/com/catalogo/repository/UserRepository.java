package com.catalogo.repository;

import com.catalogo.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
 
    Optional<User> findByEmail(String email);
    Optional <User> findByUsernameOrEmail(String username, String email); // Le coloco el Optional ya q sino no me toma el orElseThrow en CustomUserDetailsService.
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}
