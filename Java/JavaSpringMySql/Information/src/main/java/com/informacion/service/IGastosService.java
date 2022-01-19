package com.informacion.service;

import com.informacion.entities.Gastos;
import java.util.List;

public interface IGastosService {
    
    public void saveGastos(Gastos gasto);
    
    public List<Gastos> listaGastos();
    
    public void deleteGastos(Gastos gasto);
    
    public Gastos encontrarGastos(Gastos gasto);
    
}
