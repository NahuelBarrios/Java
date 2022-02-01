package com.catalogo.repository;

import com.catalogo.entities.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    public List<Producto> findByNombreProducto(String nombre);
 
    public Producto findByIdProducto(Long idProducto);
}
