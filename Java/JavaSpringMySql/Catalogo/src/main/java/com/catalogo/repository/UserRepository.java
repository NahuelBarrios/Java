package com.catalogo.repository;

import com.catalogo.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    public Optional<User> findByUsername(String username);
    
    public Boolean existsByUsername(String username);
}
