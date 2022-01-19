package com.informacion.serviceImpl;

import com.informacion.dao.GastosDao;
import com.informacion.entities.Gastos;
import com.informacion.service.IGastosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GastosServiceImpl implements IGastosService{

    @Autowired
    private GastosDao gastosDao;
    
    @Override
    public void saveGastos(Gastos gasto) {
        gastosDao.save(gasto);
    }

    @Override
    public List<Gastos> listaGastos() {
        return (List<Gastos>) gastosDao.findAll();
    }

    @Override
    public void deleteGastos(Gastos gasto) {
        gastosDao.delete(gasto);
    }

    @Override
    public Gastos encontrarGastos(Gastos gasto) {
        return gastosDao.findById(gasto.getIdGasto()).orElse(null);
    }
    
}
