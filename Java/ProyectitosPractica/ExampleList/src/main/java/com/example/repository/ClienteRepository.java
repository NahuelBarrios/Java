package com.example.repository;

import com.example.entities.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    public List<Cliente> findByNombre(String nombre);
    public Cliente findByIdCliente(Integer id);
    
}
