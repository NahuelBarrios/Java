package com.informacion.dao;

import com.informacion.entities.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosDao extends JpaRepository<Gastos,Long>{
    
}
