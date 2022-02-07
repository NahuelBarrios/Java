package com.example.repository;

import com.example.entities.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
    public List<Producto> findByNombreProducto(String nombre);
    public Producto findByIdProducto(Integer idProducto);
}
