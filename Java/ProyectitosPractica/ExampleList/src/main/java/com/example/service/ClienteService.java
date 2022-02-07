package com.example.service;

import com.example.dtos.ClienteDTO;
import com.example.entities.Cliente;
import com.example.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repoC;
    
    public Cliente crearCliente(ClienteDTO clienteDTO)
    {
        Cliente cliente = new Cliente();
        
        cliente.setNombre(clienteDTO.getNombre());
        return repoC.save(cliente);
    }
    
    public List<Cliente> listarClientes()
    {
        return (List<Cliente>)repoC.findAll();
    }
    
    public List<Cliente> nombreBuscarCliente(String nombre)
    {
        return (List<Cliente>)repoC.findByNombre(nombre);
    }
    
    public Cliente idBuscarCliente(Integer id)
    {
        return repoC.findByIdCliente(id);
    }
    
    public void guardar(Cliente cliente)
    {
        repoC.save(cliente);
    }
    
    public void borrar(Cliente cliente)
    {
        repoC.delete(cliente);
    }
    
}
