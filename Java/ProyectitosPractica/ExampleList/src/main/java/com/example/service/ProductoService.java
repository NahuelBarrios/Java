package com.example.service;

import com.example.dtos.ProductoDTO;
import com.example.entities.Producto;
import com.example.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
 
    @Autowired
    private ProductoRepository repoP;
    
    public Producto crearProducto(ProductoDTO productoDTO)
    {
        Producto producto = new Producto();
        
        producto.setNombreProducto(productoDTO.getNombreProducto());
        
        return repoP.save(producto);
    }
    
    public List<Producto> listarClientes()
    {
        return (List<Producto>)repoP.findAll();
    }
    
    public List<Producto> nombreBuscarProducto(String nombre)
    {
        return (List<Producto>)repoP.findByNombreProducto(nombre);
    }
    
    public Producto idBuscarProducto(Integer id)
    {
        return repoP.findByIdProducto(id);
    }
    
    public void guardar(Producto producto)
    {
        repoP.save(producto);
    }
    
    public void borrar(Producto producto)
    {
        repoP.delete(producto);
    }

    
}
