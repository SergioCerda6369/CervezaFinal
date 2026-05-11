package com.cerveza.cerveza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveza.cerveza.dto.StockFinalDTO;
import com.cerveza.cerveza.model.StockFinal;
import com.cerveza.cerveza.repository.StockFinalRepository;

@Service
public class StockFinalService {

    @Autowired
    private StockFinalRepository repository;

    public List<StockFinalDTO> obtenerTodos() {
        List<StockFinal> lista = repository.findAll();
        List<StockFinalDTO> dtos = new ArrayList<>();
        for (StockFinal s : lista) {
            dtos.add(convertirADTO(s));
        }
        return dtos;
    }

    public StockFinalDTO guardar(StockFinal s) {
        return convertirADTO(repository.save(s));
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private StockFinalDTO convertirADTO(StockFinal s) {
        StockFinalDTO dto = new StockFinalDTO();
        dto.setIdStockFinal(s.getIdStockFinal());
        dto.setNombreCerveza(s.getNombreCerveza());
        dto.setFormatoDistribucion(s.getFormatoDistribucion());
        dto.setCantidadDisponible(s.getCantidadDisponible());
        dto.setPrecioVenta(s.getPrecioVenta());
        return dto;
    }

}
