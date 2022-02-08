package com.example.models.response;

import com.example.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;


public class ProductoResponse {
 
    @JsonInclude(Include.NON_NULL)
    public Integer idProducto;
    
    public String nombreProducto;
    
    public List<Cliente> listaCliente = new ArrayList<>();
    
    public ProductoResponse(){}
    
    public ProductoResponse(String nombreProducto,List<Cliente> listaCliente)
    {
        this.nombreProducto = nombreProducto;
        this.listaCliente = listaCliente;
    }
    
    
    
}
