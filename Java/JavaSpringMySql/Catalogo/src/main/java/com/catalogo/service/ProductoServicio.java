package com.catalogo.service;

import com.catalogo.dtos.ProductoDTO;
import com.catalogo.entities.Producto;
import com.catalogo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    
    @Autowired
    private ProductoRepository repo;
    
    public Producto crearNuevoProducto(ProductoDTO productoDTO)
    {
        Producto producto = new Producto();
        
        producto.setImagenProducto(productoDTO.getImagenProducto());
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setPrecioProducto(productoDTO.getPrecioProducto());
        producto.setCreationDate(productoDTO.getCreationDate());
        
        return repo.save(producto);
    }
    
     public Producto buscarNombreProducto(String nombre){
         return repo.findByNombreProducto(nombre);
     }
 
    public Producto buscarIdProducto(Long idProducto){
        return repo.findByIdProducto(idProducto);
    }
    
    public void guardar(Producto producto)
    {
        repo.save(producto);
    }
    
    public void borrar(Producto producto)
    {
        repo.delete(producto);
    }
    
}
