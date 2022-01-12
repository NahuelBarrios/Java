package com.disney.dao;

import com.disney.entities.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterDao extends JpaRepository<Characters, Long> {
    
}
