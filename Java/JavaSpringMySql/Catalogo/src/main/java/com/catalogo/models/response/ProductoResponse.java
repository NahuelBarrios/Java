package com.catalogo.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

public class ProductoResponse {

    public ProductoResponse(){}
    
    public ProductoResponse(String imagenProducto, String nombreProducto, Double precioProducto, Date creationDate)
    {
        this.imagenProducto = imagenProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.fecha = creationDate;
    }
    
    @JsonInclude(Include.NON_NULL)
    public Long idProducto;
    
    public String imagenProducto;
    
    public String nombreProducto;
    
    public Double precioProducto;
    
    public Date fecha; 
}
