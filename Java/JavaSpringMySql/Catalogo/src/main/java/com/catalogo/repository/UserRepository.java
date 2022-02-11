package com.catalogo.repository;

import com.catalogo.entities.UsersLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersLog, Integer>{
    
    UsersLog findByUsername(String username);
    
    public Boolean existsByUsername(String username);
}
